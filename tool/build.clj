(require '[cljs.build.api :as b]
         '[clojure.edn :as edn])

(def args *command-line-args*)
(def build (edn/read-string (first args)))

(println "Building ...")

(let [start (System/nanoTime)
      {:keys [src compiler]} build]
  (b/build src compiler)
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))