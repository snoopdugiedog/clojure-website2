(defproject website2 "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.1"]
                           [jayq "0.1.0-SNAPSHOT"]
                           [crate "0.1.0-SNAPSHOT"]
                           ]
            ;; lein-cljsbuild
            ;; https://github.com/emezeske/lein-cljsbuild
            ;; which I found from this site:
            ;; http://corfield.org/blog/post.cfm/getting-started-with-clojurescript-and-fw-1
            :dev-dependencies [[lein-cljsbuild "0.0.12"]]
            :cljsbuild {
                        :source-path "src-cljs"
                        :compiler {
                                   :output-to "resources/public/js/main.js"
                                   :externs ["externs/jquery.js"]
                                   :optimizations :whitespace
                                   :pretty-print true}}
            :main website2.server)

