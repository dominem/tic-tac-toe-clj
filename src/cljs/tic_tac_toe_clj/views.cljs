(ns tic-tac-toe-clj.views
  (:require [re-frame.core :as re-frame]
            [tic-tac-toe-clj.subs :as subs]
            [tic-tac-toe-clj.events :as events]
            [tic-tac-toe-clj.styles :as styles]))

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
  (re-frame/dispatch [::events/start-playing]))

(defn start-button []
  [:div.start {:on-click dispatch-start-playing}
   [:button "Start"]])

(defn start-panel []
  [:div
   (heading)
   (size-selector)
   (start-button)])

(defn cell [idx db-cell]
  [:div.cell {:key idx :style (styles/cell)}])

(defn row [idx db-row]
  [:div.row {:key idx :style (styles/row)}
   (map-indexed cell db-row)])

(defn board-line [size x-offset y-offset]
  [:div.board-line
   {:key   (str x-offset y-offset)
    :style (styles/board-line size x-offset y-offset)}
   [:div {:style (styles/board-line-inner size x-offset y-offset)}]])

(defn board-lines [db-board]
  (let [size (count db-board)]
    (concat
      (for [x-offset (range 1 size)]
        (board-line size x-offset 0))
      (for [y-offset (range 1 size)]
        (board-line size 0 y-offset)))))

(defn board []
  (let [db-board @(re-frame/subscribe [::subs/board])]
    [:div.board {:style (styles/board db-board)}
     (map-indexed row db-board)
     (board-lines db-board)]))

(defn main-panel []
  (let [playing? (re-frame/subscribe [::subs/playing?])]
    (if (not @playing?)
      (start-panel)
      (board))))
