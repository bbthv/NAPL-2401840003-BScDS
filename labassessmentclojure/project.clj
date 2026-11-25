
(defproject clojure-data-pipeline "1.0.0"
  :description "Clojure Data Pipeline with Ring and SQLite"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [ring/ring-core "1.12.2"]
                 [ring/ring-jetty-adapter "1.12.2"]
                 [org.xerial/sqlite-jdbc "3.46.1.0"]]
  :main core
  :source-paths ["src"])
