(ns prime_multiplication.core
  (:require [clojure.math.numeric-tower :refer [exact-integer-sqrt]]
            [clojure.pprint :refer [print-table]]
			))

(defn primeNum? [val]
  (if (> val 1)
    (let [intVal (first (exact-integer-sqrt val))]
      (nil? (some #(= 0 (mod val %)) (range 2 (inc intVal)))))
    false))

(defn fetch-primes [number]
  (take number (filter primeNum? (range))))

(defn -main [& ag]
  "Prints out a table of prime numbers"
  
  (let [root "RowVsCol" defaultnum 10
	    start (System/currentTimeMillis)
        num (try (Integer/parseInt (first ag)) (catch Exception e defaultnum))
        p (fetch-primes num)
        numofCol (concat [root] p)
        numofRow (map #(merge {root %} (zipmap p (map (partial * %) p))) p)
		finish (System/currentTimeMillis)]
		(println "time taken to find the prime numbers:" (- finish start) "millisecs")
		
 (let [formatStartTime (System/currentTimeMillis)]
		(print-table numofCol numofRow) (println "Time taken for formatting:" (- (System/currentTimeMillis) formatStartTime) "millisecs")
 )))
