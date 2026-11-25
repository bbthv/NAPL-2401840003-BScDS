
(ns core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.response :as response])
  (:import [java.sql DriverManager]))

;; 1. Sample Dataset
(def students
  [{:id 1 :name "Sneha" :marks 85}
   {:id 2 :name "Davik" :marks 45}
   {:id 3 :name "Palak" :marks 92}])

;; 2. Process Data
(defn process-data []
  (let [passed (filter #(>= (:marks %) 40) students)
        names (map :name passed)
        total (reduce + (map :marks passed))]
    {:students (vec names)
     :total total}))

;; 3. Database Connection
(def db "jdbc:sqlite:students.db")

;; 4. Create Table and Insert Data
(defn database []
  (try
    (Class/forName "org.sqlite.JDBC")
    (with-open [conn (DriverManager/getConnection db)
                stmt (.createStatement conn)]
      (.executeUpdate stmt
                      "CREATE TABLE IF NOT EXISTS students
         (id INTEGER, name TEXT, marks INTEGER)")

      (.executeUpdate stmt "DELETE FROM students")

      (doseq [s students]
        (.executeUpdate stmt
                        (str "INSERT INTO students VALUES ("
                             (:id s) ", '"
                             (:name s) "', "
                             (:marks s) ")"))))

    (println "Database created and data inserted")

    (catch Exception e
      (println "Error:" (.getMessage e)))))

;; 5. Read Database
(defn read-data []
  (try
    (with-open [conn (DriverManager/getConnection db)
                stmt (.createStatement conn)
                rs (.executeQuery stmt "SELECT * FROM students")]
      (loop [result []]
        (if (.next rs)
          (recur
           (conj result
                 {:id (.getInt rs "id")
                  :name (.getString rs "name")
                  :marks (.getInt rs "marks")}))
          result)))

    (catch Exception e
      (println "Read Error:" (.getMessage e))
      [])))

;; 6. Ring HTTP Endpoint
(defn handler [request]
  (case (:uri request)
    "/students"
    (response/response (pr-str (read-data)))

    "/processed"
    (response/response (pr-str (process-data)))

    (response/not-found "Not Found")))

;; 7. Main Function
(defn -main []
  (println "Starting Data Pipeline...")

  (database)

  (println "Students:" (read-data))
  (println "Processed Data:" (process-data))

  (jetty/run-jetty handler
                   {:port 3000 :join? true}))
