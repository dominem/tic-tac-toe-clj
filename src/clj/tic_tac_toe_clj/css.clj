(ns tic-tac-toe-clj.css
  (:require [garden.def :refer [defstyles defkeyframes]]))

(defkeyframes board-line-vertical
  [:from {:height 0}]
  [:to {:height "100%"}])

(defkeyframes board-line-horizontal
  [:from {:width 0}]
  [:to {:width "100%"}])

(defstyles screen
  board-line-vertical
  board-line-horizontal

  [[:* {:box-sizing :border-box}]

   [:h1.heading {:text-align :center}]

   [:div.size-selector {:width "64px" :margin "40px auto"}
    [:select {:width "100%" :font-size "1.4rem"}]]

   [:div.start {:width "140px" :margin "30px auto"}
    [:button {:width "100%" :font-size "1.6rem"}]]

   [:div.cell {:display    :inline-block
               :background :white
               :opacity    0.1
               :transition "background .2s ease-out"}
    [:&:hover {:background "#0b9de8"
               :cursor     :pointer}]]

   [:div.board {:margin   :auto
                :position :relative}]

   [:div.board-line {:position :absolute}
    [:div {:background                "#0b9de8"
           :opacity                   0.4
           :border-radius             "10px"
           :animation-fill-mode       :forwards
           :animation-timing-function :ease-out}]]])
