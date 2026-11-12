
;; Experiment 18: Sequence Transformations

;; First Collection
(println "----- FIRST COLLECTION -----")

(def nums [1 2 3 4 5 6 7 8])

(println "Original Collection:" nums)

;; 1. MAP - Square each element
(println "Squares:" (map #(* % %) nums))

;; 2. FILTER - Select even numbers
(println "Even Numbers:" (filter even? nums))

;; 3. REDUCE - Calculate sum
(println "Sum:" (reduce + nums))

;; 4. TAKE - Take first 4 elements
(println "Take 4:" (take 4 nums))

;; DROP - Remove first 4 elements
(println "Drop 4:" (drop 4 nums))

;; Threading Macro ->>
(println "Threading Result:"
         (->> nums
              (filter even?)
              (map #(* % %))
              (take 2)))


;; Second Collection
(println "\n----- SECOND COLLECTION -----")

(def nums2 '(10 15 20 25 30 35))

(println "Original Collection:" nums2)

;; MAP
(println "Squares:" (map #(* % %) nums2))

;; FILTER
(println "Even Numbers:" (filter even? nums2))

;; REDUCE
(println "Sum:" (reduce + nums2))

;; TAKE
(println "Take 3:" (take 3 nums2))

;; DROP
(println "Drop 3:" (drop 3 nums2))

;; Threading Macro ->>
(println "Threading Result:"
         (->> nums2
              (filter even?)
              (map #(* % %))
              (take 2)))
