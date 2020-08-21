(ns tic-tac-toe-clj.events
  (:require [re-frame.core :as re-frame]
            [tic-tac-toe-clj.db :as db]
            [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re-frame/reg-event-db
  ::initialize-db
  (fn-traced [_ _] db/default-db))

(re-frame/reg-event-db
  ::set-size
  (fn-traced [db [_ size]] (assoc db :size size)))

(re-frame/reg-event-db
  ::start-playing
  (fn-traced [db _] (assoc db :playing? true)))

(re-frame/reg-event-db
  ::create-board
  (fn-traced [db _] (assoc db :board (db/empty-board (:size db)))))
