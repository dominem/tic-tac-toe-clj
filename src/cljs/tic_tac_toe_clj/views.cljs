(ns tic-tac-toe-clj.views
  (:require
   [re-frame.core :as re-frame]
   [tic-tac-toe-clj.subs :as subs]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     ]))
