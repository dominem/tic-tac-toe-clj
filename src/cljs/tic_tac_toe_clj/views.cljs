(ns tic-tac-toe-clj.views
  (:require [re-frame.core :as re-frame]
            [tic-tac-toe-clj.subs :as subs]))

(def heading [:h1.heading "Tic Tac Toe"])

(defn size-option [n]
  (let [size (str n "x" n)]
    [:option {:value size :key n} size]))

(defn size-options [& sizes]
  (for [size sizes] (size-option size)))

(def size-selector
  [:select (size-options 3 4 5)])

(defn main-panel []
  [:div heading
   size-selector])
