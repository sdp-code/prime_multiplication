(ns prime_multiplication.core-test
  (:require [clojure.test :refer :all]
            [prime_multiplication.core :refer :all]))

(deftest test-primes
  (testing "prime .."
    (is (not (primeNum? -1)))
    (is (not (primeNum? 0)))
    (is (not (primeNum? 1)))
    (is (primeNum? 2))
    (is (primeNum? 3))
    (is (not (primeNum? 4)))
 
  ))

(deftest testprimes
  (testing "getting the first n primes"
    (is (= [] (fetch-primes 0)))
    (is (= [2] (fetch-primes 1)))
    (is (= [2 3] (fetch-primes 2)))
    (is (= [2 3 5 7 11 14 17] (fetch-primes 7)))))

