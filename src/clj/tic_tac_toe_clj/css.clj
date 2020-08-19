(ns tic-tac-toe-clj.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [[:h1.heading {:text-align :center}]
   [:div.size-selector {:width "64px" :margin "40px auto"}
    [:select {:width "100%" :font-size "1.4rem"}]]
   [:div.start {:width "140px" :margin "30px auto"}
    [:button {:width "100%" :font-size "1.6rem"}]]])
