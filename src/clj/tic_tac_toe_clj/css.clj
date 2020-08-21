(ns tic-tac-toe-clj.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [[:* {:box-sizing :border-box}]

   [:h1.heading {:text-align :center}]

   [:div.size-selector {:width "64px" :margin "40px auto"}
    [:select {:width "100%" :font-size "1.4rem"}]]

   [:div.start {:width "140px" :margin "30px auto"}
    [:button {:width "100%" :font-size "1.6rem"}]]

   [:div.cell {:width "60px"
               :height "60px"
               :border "1px solid black"
               :display "inline-block"}]

   [:div.row {:height "60px"}]])
