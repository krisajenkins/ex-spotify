(ns ex-spotify.spotify
  (:require [clj-http.client :as http]
            [clojure.edn :as edn]
            [cheshire.core :refer [parse-string]]
            [clojure.pprint :refer [pprint]]))

(defn query-spotify
  "Run an arbitrary query agains Spotify's API."
  [query]
  (parse-string (:body (http/get "http://ws.spotify.com/search/1/track.json"
                                 {:query-params {:q query}}))
                true))
