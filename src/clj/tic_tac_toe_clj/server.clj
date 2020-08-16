(ns tic-tac-toe-clj.server
  (:require [tic-tac-toe-clj.handler :refer [handler]]
            [config.core :refer [env]]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

 (defn -main [& _args]
   (let [port (or (env :port) "3000")]
     (run-jetty handler {:port port :join? false})))
