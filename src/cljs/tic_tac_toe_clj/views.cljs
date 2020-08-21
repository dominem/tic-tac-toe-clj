(ns tic-tac-toe-clj.views
  (:require [re-frame.core :as re-frame]
            [tic-tac-toe-clj.subs :as subs]
            [tic-tac-toe-clj.events :as events]))

(defn heading []
  [:h1.heading "Tic Tac Toe"])

(defn size-option [n]
  (let [size (str n "x" n)]
    [:option {:value n :key n} size]))

(defn size-options [& sizes]
  (for [size sizes] (size-option size)))

(defn dispatch-set-size [event]
  (re-frame/dispatch
    [::events/set-size (js/parseInt (-> event .-target .-value))]))

(defn size-selector []
  [:div.size-selector
   (let [size (re-frame/subscribe [::subs/size])]
     [:select {:value @size :on-change dispatch-set-size}
      (size-options 3 4 5)])])

(defn dispatch-start-playing []
  (re-frame/dispatch [::events/start-playing])
  (re-frame/dispatch [::events/create-board]))

(defn start-button []
  [:div.start {:on-click dispatch-start-playing}
   [:button "Start"]])

(defn start-panel []
  [:div
   (heading)
   (size-selector)
   (start-button)])

(defn cell [i db-cell]
  [:div.cell {:key i}])

(defn row [idx db-row]
  [:div.row {:key idx} (map-indexed cell db-row)])

(defn board [db-board]
  [:div.board (map-indexed row db-board)])

(defn playing-panel []
  (when-let [db-board @(re-frame/subscribe [::subs/board])]
    [:div (board db-board)]))

(defn main-panel []
  (let [playing? (re-frame/subscribe [::subs/playing?])]
    (if (not @playing?)
      (start-panel)
      (playing-panel))))
