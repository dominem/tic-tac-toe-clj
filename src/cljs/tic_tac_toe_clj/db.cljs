(ns tic-tac-toe-clj.db)

(def default-db
  {:size     3
   :playing? false
   :board    nil})

(defn empty-board [size]
  (take size (repeat (take size (repeat nil)))))

(comment
  (empty-board 3)
  (empty-board 4)
  (empty-board 5))

(defn compare-cells [x y]
  (let [x-pos (ffirst x) y-pos (ffirst y)]
    (let [c (compare (:row x-pos) (:row y-pos))]
      (if (not= c 0)
        c
        (compare (:col x-pos) (:col y-pos))))))

(comment
  (sort compare-cells '({{:row 0, :col 0} nil}
                        {{:row 0, :col 1} nil}
                        {{:row 2, :col 0} nil}
                        {{:row 0, :col 2} nil}
                        {{:row 1, :col 0} nil}
                        {{:row 2, :col 1} nil}
                        {{:row 1, :col 1} nil}
                        {{:row 1, :col 2} nil}
                        {{:row 2, :col 2} nil})))

(defn empty-cell [row col]
  {:row row :col col :val nil})

(defn empty-board-2 [size]
  (->> (for [row (range size)]
         (for [col (range size)]
           (empty-cell row col)))
       (apply concat)
       (partition-by :row)))

(comment
  (empty-board-2 3)
  (empty-board-2 4)
  (empty-board-2 5)
  (apply concat (empty-board-2 3))
  (into {} (map (fn [x] [{:row (:row x) :col (:col x)} x])
                (apply concat (empty-board-2 3))))
  (into {} (empty-board-2 3)))