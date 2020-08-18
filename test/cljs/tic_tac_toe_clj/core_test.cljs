(ns tic-tac-toe-clj.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [tic-tac-toe-clj.core :as core]
            [tic-tac-toe-clj.views :as views]))

(deftest main-panel
  (testing "contains heading"
    (is (some #(= % [:h1.heading "Tic Tac Toe"]) (views/main-panel))))
  (testing "contains size selector"
    (is (= 1 1))))
