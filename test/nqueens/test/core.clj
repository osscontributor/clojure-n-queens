(ns nqueens.test.core
  (:use [nqueens.core] :reload)
  (:use [clojure.test]))

(deftest test-adding-in-occupied-diagonal
    (is (= false (is-valid-addition? [2 4 1] 5))))    
    
(deftest test-adding-to-empty-board
    (is (= true (is-valid-addition? [] 3))))    
    
(deftest test-adding-in-occupied-column
    (is (= false (is-valid-addition? [2 4 1] 2))))
    
(deftest test-adding-to-valid-position
    (is (= true (is-valid-addition? [2 4 1] 3))))    

(deftest test-adding-row-to-empty-board
    (let [results (add-to-boards [[]] 4)]
        (is (= 4 (count results)))
        (is (some #{[1]} results))
        (is (some #{[2]} results))
        (is (some #{[3]} results))
        (is (some #{[4]} results))))
    
(deftest test-adding-to-board-with-one-row
    (let [results (add-to-boards [[2]] 4)]
        (is (= 1 (count results)))
        (is (= [2 4] (first results)))))
        
(deftest test-adding-to-board-with-multiple-rows
    (let [results (add-to-boards [[2 4]] 7)]
        (is (= 3 (count results)))
        (is (some #{[2 4 1]} results))    
        (is (some #{[2 4 6]} results))
        (is (some #{[2 4 7]} results))))    

(deftest test-solving-board-size-4
    (let [results (solve-for-board-size 4)]
        (is (= 2 (count results)))
        (is (some #{[2 4 1 3]} results))
        (is (some #{[3 1 4 2]} results))))

(deftest test-solving-board-size-5
    (let [results (solve-for-board-size 5)]
        (is (= 10 (count results)))
        (is (some #{[1 3 5 2 4]} results))
        (is (some #{[1 4 2 5 3]} results))
        (is (some #{[2 4 1 3 5]} results))
        (is (some #{[2 5 3 1 4]} results))
        (is (some #{[3 1 4 2 5]} results))
        (is (some #{[3 5 2 4 1]} results))
        (is (some #{[4 1 3 5 2]} results))
        (is (some #{[4 2 5 3 1]} results))
        (is (some #{[5 2 4 1 3]} results))
        (is (some #{[5 3 1 4 2]} results))))
        
        
        
        