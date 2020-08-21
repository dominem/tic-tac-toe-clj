(ns tic-tac-toe-clj.db)

(def default-db
  {:size 3
   :playing? false
   :board nil})

(defn empty-board [size]
  (take size (repeat (take size (repeat nil)))))
