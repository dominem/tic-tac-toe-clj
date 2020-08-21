(ns tic-tac-toe-clj.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
  ::size
  (fn [db] (:size db)))

(re-frame/reg-sub
  ::playing?
  (fn [db] (:playing? db)))

(re-frame/reg-sub
  ::board
  (fn [db] (:board db)))
