(ns tic-tac-toe-clj.styles)

(def cell-width 80)
(def cell-height cell-width)

(def row-height cell-height)

(def board-line-size 6)
(def board-line-size-half (/ board-line-size 2))

(defn board-width [board-size] (* cell-width board-size))

(defn px [size] (str size "px"))

(defn cell []
  {:width  (px cell-width)
   :height (px cell-height)})

(defn row [] {:height (px row-height)})

(defn board [db-board]
  {:width (px (board-width (count db-board)))})

(defn board-line [size x-offset y-offset]
  {:top    (px (- (* cell-height y-offset)
                  (if (zero? y-offset) 0 board-line-size-half)))
   :left   (px (- (* cell-width x-offset)
                  (if (zero? x-offset) 0 board-line-size-half)))
   :width  (if (zero? x-offset)
             (px (* cell-width size))
             (px board-line-size))
   :height (if (zero? y-offset)
             (px (* cell-height size))
             (px board-line-size))})

(defn board-line-inner-delay [base-delay size x-offset y-offset]
  (if (zero? y-offset)
    (str (* base-delay x-offset) "s")
    (str (+ (* base-delay (dec size)) (* base-delay y-offset)) "s")))

(defn board-line-inner [size x-offset y-offset]
  (let [vertical? (zero? y-offset)
        base-delay (+ 0.05 (* size 0.02))]
    {:width              (if (not vertical?) 0 "100%")
     :height             (if vertical? 0 "100%")
     :animation-duration (str (+ base-delay 0.2) "s")
     :animation-delay    (board-line-inner-delay
                           base-delay
                           size
                           x-offset
                           y-offset)
     :animation-name     (if vertical?
                           :board-line-vertical
                           :board-line-horizontal)}))
