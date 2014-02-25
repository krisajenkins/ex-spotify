(ns ex-spotify.spotify
  (:require [clj-http.client :as http]
            [cheshire.core :refer [parse-string]]
            [clojure.pprint :refer [pprint]]))

(def love
  {:info
   {:num_results 1286416
    :limit 100
    :offset 0
    :query "love"
    :type "track"
    :page 1}
   :tracks
   [{:album
     {:released "2013"
      :href "spotify:album:7bCDE4ddc9T8Zkw588bN73"
      :name "Love Me Again"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Love Me Again"
     :popularity "0.93"
     :external-ids [{:type "isrc" :id "GBUM71301538"}]
     :length 240.559
     :href "spotify:track:57PjISfyOyDcvTPipz16nf"
     :artists
     [{:href "spotify:artist:34v5MVKeQnIo0CWYMbbrPf"
       :name "John Newman"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:7w19PFbxAjwZ7UVNp9z0uT"
      :name "18 Months"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "I Need Your Love"
     :popularity "0.94"
     :external-ids [{:type "isrc" :id "GBARL1201390"}]
     :length 234.781
     :href "spotify:track:05SBRd4fXgn8FX7bf8BCAE"
     :artists
     [{:href "spotify:artist:7CajNmpbOovFoOoasH2HaY"
       :name "Calvin Harris"}
      {:href "spotify:artist:0X2BH1fck6amBIoJhDVmmJ"
       :name "Ellie Goulding"}]
     :track-number "8"}
    {:href "spotify:track:5xGIqIiGr1do6RRpIviwGG"
     :track-number "1"
     :artists
     [{:href "spotify:artist:7bXgB6jMjp9ATFy66eO08Z"
       :name "Chris Brown"}
      {:href "spotify:artist:0hCNtLu0JehylgoiP8L4Gh"
       :name "Nicki Minaj"}]
     :name "Love More"
     :external-ids [{:type "isrc" :id "USRC11300977"}]
     :explicit true
     :popularity "0.85"
     :length 190.073
     :album
     {:released "2013"
      :href "spotify:album:1GdHAXJBCb70LRcG2uOiWf"
      :name "Love More"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}}
    {:href "spotify:track:3VZQshi4COChhXaz7cLP02"
     :track-number "1"
     :artists
     [{:href "spotify:artist:1VBflYyxBhnDc9uVib98rw"
       :name "Icona Pop"}]
     :name "I Love It [feat. Charli XCX] - Original Version"
     :external-ids [{:type "isrc" :id "USAT21202802"}]
     :explicit true
     :popularity "0.87"
     :length 155.536
     :album
     {:released "2012"
      :href "spotify:album:5hf74KpfuwSJXVs85k3dVI"
      :name "I Love It"
      :availability
      {:territories
       "AT BE CA CH DE DK EE ES FI FR GB GR IE IS IT LT LU LV NL NO NZ PL PT TR US"}}}
    {:album
     {:released "2012"
      :href "spotify:album:76FXHQhTuT4QMIxfL09gX8"
      :name "The Heist"
      :availability
      {:territories
       "AD AT AU BE CA DE DK EE ES FI GB GR IE IS IT LI LT LU LV MC NL NO NZ PL PT SE TR US"}}
     :name "Same Love - feat. Mary Lambert"
     :popularity "0.92"
     :external-ids [{:type "isrc" :id "GMM881200024"}]
     :length 318.863
     :href "spotify:track:01uqI4H13Gsd8Lyl1EYd8H"
     :artists
     [{:href "spotify:artist:5BcAKTbp20cv7tC5VqPFoC"
       :name "Macklemore & Ryan Lewis"}]
     :track-number "5"}
    {:album
     {:released "2013"
      :href "spotify:album:7s7MABPBT1MxTzvD0MBZTH"
      :name "Other Side Of Love"
      :availability
      {:territories
       "AD AT AU BE CA CH DE DK EE ES FI FR GB GR IE IS IT LT LU LV MC NL NO NZ PL PT SE TR US"}}
     :name "Other Side Of Love"
     :popularity "0.85"
     :external-ids [{:type "isrc" :id "USAT21301619"}]
     :length 186.125
     :href "spotify:track:4RdUpI3iTwqzCQe9ttKB5Q"
     :artists
     [{:href "spotify:artist:3Isy6kedDrgPYoTS1dazA9"
       :name "Sean Paul"}]
     :track-number "1"}
    {:href "spotify:track:1QNqrsNQ1JVLEwncov3lEY"
     :track-number "5"
     :artists
     [{:href "spotify:artist:1KCSPY1glIKqW2TotWuXOR" :name "P!nk"}
      {:href "spotify:artist:13saZpZnCDWOI9D4IJhp1f"
       :name "Lily Allen"}]
     :name "True Love"
     :external-ids [{:type "isrc" :id "USRC11200787"}]
     :explicit true
     :popularity "0.82"
     :length 230.99
     :album
     {:released "2012"
      :href "spotify:album:2Q9oTK48eb85waX1fFJsvj"
      :name "The Truth About Love"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}}
    {:album
     {:released "2012"
      :href "spotify:album:2Q9oTK48eb85waX1fFJsvj"
      :name "The Truth About Love"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Just Give Me a Reason"
     :popularity "0.89"
     :external-ids [{:type "isrc" :id "USRC11200786"}]
     :length 243.016
     :href "spotify:track:1mKXFLRA179hdOWQBwUk9e"
     :artists
     [{:href "spotify:artist:1KCSPY1glIKqW2TotWuXOR" :name "P!nk"}
      {:href "spotify:artist:1qUjOF5fzrpoNycD36b2jZ"
       :name "Nate Ruess"}]
     :track-number "4"}
    {:href "spotify:track:4lWJjtWbDDALpK9tVG8Dho"
     :track-number "1"
     :artists
     [{:href "spotify:artist:55Aa2cqylxrFIXC767Z865" :name "Lil Wayne"}
      {:href "spotify:artist:3TVXtAsR1Inumwj472S9r4" :name "Drake"}
      {:href "spotify:artist:1RyvyyTE3xzB2ZywiAwp0i" :name "Future"}]
     :name "Love Me"
     :external-ids [{:type "isrc" :id "USCM51300001"}]
     :explicit true
     :popularity "0.78"
     :length 255.566
     :album
     {:released "2013"
      :href "spotify:album:4jTKbfelfDkv7sLjK8EhKo"
      :name "Love Me"
      :availability {:territories "CA MX US"}}}
    {:href "spotify:track:3JvKfv6T31zO0ini8iNItO"
     :track-number "3"
     :artists
     [{:href "spotify:artist:2txHhyCwHjUEpJjWrEyqyX"
       :name "Tom Odell"}]
     :name "Another Love"
     :external-ids [{:type "isrc" :id "GBARL1300107"}]
     :explicit true
     :popularity "0.81"
     :length 244.637
     :album
     {:released "2013"
      :href "spotify:album:0Gf1yE895FKK4YWVRuAeg8"
      :name "Long Way Down (Deluxe)"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW"}}}
    {:album
     {:released "2013"
      :href "spotify:album:53rR6zjaUDjeWlUveFMSjE"
      :name "The Love Club EP"
      :availability {:territories "CA MX US"}}
     :name "The Love Club"
     :popularity "0.77"
     :external-ids [{:type "isrc" :id "NZUM71200034"}]
     :length 201.681
     :href "spotify:track:4jiPmKPLym7K90mrSqiJps"
     :artists
     [{:href "spotify:artist:163tK9Wjr9P9DmM0AVK7lm" :name "Lorde"}]
     :track-number "4"}
    {:album
     {:released "2003"
      :href "spotify:album:6oxVabMIqCMJRYN1GqR3Vf"
      :name "Dangerously In Love"
      :availability
      {:territories
       "AD AR AU BE CA DK EE ES FI FR GB GR HK IE IS IT LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Crazy In Love"
     :popularity "0.76"
     :external-ids [{:type "isrc" :id "USSM10305425"}]
     :length 236.402
     :href "spotify:track:5IVuqXILoxVWvWEPm82Jxr"
     :artists
     [{:href "spotify:artist:6vWDO969PvNqNYHIOW5v0m" :name "Beyoncé"}
      {:href "spotify:artist:3nFkdlSjzX9mRTtwJOzDYB" :name "JAY Z"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:4OTAx9un4e6NfoHuVRiOrC"
      :name "Love In The Future"
      :availability
      {:territories
       "AD AR AT BE CA CH DE EE ES FI FR GB GR HK IE IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Made to Love"
     :popularity "0.77"
     :external-ids [{:type "isrc" :id "USSM11301823"}]
     :length 240.611
     :href "spotify:track:1G2Ya2ubnlS7xFfs1CfY3j"
     :artists
     [{:href "spotify:artist:5y2Xq6xcjJb2jVM54GHK3t"
       :name "John Legend"}]
     :track-number "4"}
    {:album
     {:released "2011"
      :href "spotify:album:1WGjSVIw0TVfbp5KrOFiP0"
      :name "Birdy"
      :availability
      {:territories
       "AT BE CA CH DE DK EE FI GR IE IS IT LT LU LV NL NO NZ PL SE TR US"}}
     :name "Skinny Love"
     :popularity "0.79"
     :external-ids [{:type "isrc" :id "GBAHS1100350"}]
     :length 203.302
     :href "spotify:track:4RL77hMWUq35NYnPLXBpih"
     :artists
     [{:href "spotify:artist:2WX2uTcsvV5OnS0inACecP" :name "Birdy"}]
     :track-number "2"}
    {:album
     {:released "2012"
      :href "spotify:album:7i1Ej2Ix9aIiLKqhNwAB2l"
      :name "Overexposed"
      :availability {:territories "CA US"}}
     :name "Love Somebody"
     :popularity "0.79"
     :external-ids [{:type "isrc" :id "USUM71204774"}]
     :length 230.075
     :href "spotify:track:0HnaqUxvHP5LaWdmWwJpiS"
     :artists
     [{:href "spotify:artist:04gDigrS5kc9YWfZHwBETP" :name "Maroon 5"}]
     :track-number "6"}
    {:album
     {:released "2011"
      :href "spotify:album:2JWBVBmidYbaAR6o6bwcnC"
      :name "We Found Love"
      :availability
      {:territories
       "AR AU BE CH DE DK EE ES FI FR GR HK IE IS IT LT LU LV MY NL NO NZ PL PT SG TR TW"}}
     :name "We Found Love"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "USUM71115507"}]
     :length 216.009
     :href "spotify:track:14fmbvjYLqRZEXz1VZdM2M"
     :artists
     [{:href "spotify:artist:5pKCCKE2ajJHZ9KAiaK11H" :name "Rihanna"}
      {:href "spotify:artist:7CajNmpbOovFoOoasH2HaY"
       :name "Calvin Harris"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:155N1gV0cIFYaLiy3I5d83"
      :name "The Lumineers"
      :availability {:territories "US"}}
     :name "Stubborn Love"
     :popularity "0.78"
     :external-ids [{:type "isrc" :id "USDMG1260807"}]
     :length 279.306
     :href "spotify:track:4nOi8Y22QaxmAEkIrpb5Fv"
     :artists
     [{:href "spotify:artist:16oZKvXb6WkQlVAjwo2Wbg"
       :name "The Lumineers"}]
     :track-number "7"}
    {:album
     {:released "2013"
      :href "spotify:album:712VoD72K500yLhhgqCyVe"
      :name "Paradise Valley"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Who You Love"
     :popularity "0.79"
     :external-ids [{:type "isrc" :id "USSM11303945"}]
     :length 250.206
     :href "spotify:track:7IByJvSqRFltGyiiIiL4wn"
     :artists
     [{:href "spotify:artist:0hEurMDQu99nJRq8pTxO14" :name "John Mayer"}
      {:href "spotify:artist:6jJ0s89eD6GaHleKKya26X"
       :name "Katy Perry"}]
     :track-number "6"}
    {:album
     {:released "2013"
      :href "spotify:album:02h9kO2oLKnLtycgbElKsw"
      :name "True"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "All You Need Is Love"
     :popularity "0.81"
     :external-ids [{:type "isrc" :id "CH3131340105"}]
     :length 381.506
     :href "spotify:track:7oSlMkRv5AhPnnGWdFTv20"
     :artists
     [{:href "spotify:artist:1vCWHaC5f2uS3yhpwWbIA6" :name "Avicii"}]
     :track-number "12"}
    {:album
     {:released "2012"
      :href "spotify:album:1gCm0NwF4wKC3MXmoaNSoz"
      :name "The Love Club EP"
      :availability {:territories "AU NL NZ"}}
     :name "Royals"
     :popularity "0.81"
     :external-ids [{:type "isrc" :id "NZUM71200031"}]
     :length 190.413
     :href "spotify:track:4w8CsAnzn0lXJxYlAuCtCW"
     :artists
     [{:href "spotify:artist:163tK9Wjr9P9DmM0AVK7lm" :name "Lorde"}]
     :track-number "2"}
    {:album
     {:released "2008"
      :href "spotify:album:2wBGb1zLSWrmiOdinWE831"
      :name "For Emma, Forever Ago"
      :availability
      {:territories
       "AD AT BE CH DE DK EE ES FI FR GB GR IE IS IT LI LT LU LV MC NL NO PL PT SE TR"}}
     :name "Skinny Love"
     :popularity "0.77"
     :external-ids [{:type "isrc" :id "US38Y0811503"}]
     :length 238.781
     :href "spotify:track:7fXyuQqEBwpKtCa8PomO7B"
     :artists
     [{:href "spotify:artist:4LEiUm1SRbFMgfqnQTwUbQ" :name "Bon Iver"}]
     :track-number "3"}
    {:href "spotify:track:1pzSeZfdQODtB9xmkH0Q91"
     :track-number "7"
     :artists
     [{:href "spotify:artist:5YGY8feqx7naU7z4HrwZM6"
       :name "Miley Cyrus"}
      {:href "spotify:artist:0c173mlxpT3dSFRgMO8XPh" :name "Big Sean"}]
     :name "Love Money Party"
     :external-ids [{:type "isrc" :id "USRC11300913"}]
     :explicit true
     :popularity "0.78"
     :length 220.035
     :album
     {:released "2013"
      :href "spotify:album:3RDqXDc1bAETps54MSSOW0"
      :name "Bangerz (Deluxe Version)"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}}
    {:href "spotify:track:35hW18HrovbypDjBg1R2kw"
     :track-number "5"
     :artists
     [{:href "spotify:artist:1KCSPY1glIKqW2TotWuXOR" :name "P!nk"}
      {:href "spotify:artist:13saZpZnCDWOI9D4IJhp1f"
       :name "Lily Allen"}]
     :name "True Love"
     :external-ids [{:type "isrc" :id "USRC11200787"}]
     :explicit true
     :popularity "0.74"
     :length 230.99
     :album
     {:released "2012"
      :href "spotify:album:2rBb9rAEuMC8VH9uk7js3e"
      :name "The Truth About Love"
      :availability {:territories "US"}}}
    {:album
     {:released "2012"
      :href "spotify:album:6ThvD7x2ULvoqQ3Wycq4uK"
      :name "This Is Love"
      :availability
      {:territories
       "AR AT AU BE CH DE DK EE ES FI FR GR HK IS IT LT LU LV MY NL NO NZ PL PT SG TR TW"}}
     :name "This Is Love"
     :popularity "0.74"
     :external-ids [{:type "isrc" :id "USUM71205053"}]
     :length 281.24
     :href "spotify:track:6zX1edWck5DxIBWQMOUXO5"
     :artists
     [{:href "spotify:artist:085pc2PYOi8bGKj0PNjekA" :name "will.i.am"}
      {:href "spotify:artist:2d6W4cnC5XsVOaxtgaj9hA"
       :name "Eva Simons"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:2Q9oTK48eb85waX1fFJsvj"
      :name "The Truth About Love"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Try"
     :popularity "0.81"
     :external-ids [{:type "isrc" :id "USRC11200785"}]
     :length 248.193
     :href "spotify:track:1jF7IL57ayN4Ity3jQqGu0"
     :artists
     [{:href "spotify:artist:1KCSPY1glIKqW2TotWuXOR" :name "P!nk"}]
     :track-number "3"}
    {:album
     {:released "2011"
      :href "spotify:album:4rG0MhkU6UojACJxkMHIXB"
      :name "Planet Pit (Deluxe Version)"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "International Love"
     :popularity "0.77"
     :external-ids [{:type "isrc" :id "USJAY1100015"}]
     :length 227.539
     :href "spotify:track:62zFEHfAYl5kdHYOivj4BC"
     :artists
     [{:href "spotify:artist:0TnOYISbd1XYRBk9myaseg" :name "Pitbull"}
      {:href "spotify:artist:7bXgB6jMjp9ATFy66eO08Z"
       :name "Chris Brown"}]
     :track-number "8"}
    {:album
     {:released "2012"
      :href "spotify:album:6SRwxmQjAneSSyfhE7fv37"
      :name "Feel The Love"
      :availability {:territories "AU BE FR GB IE LU NL TR US"}}
     :name "Feel The Love - feat. John Newman"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "GBAHS1200174"}]
     :length 245.474
     :href "spotify:track:0nypsuS2jtogLaJDcRQ4Ya"
     :artists
     [{:href "spotify:artist:4WN5naL3ofxrVBgFpguzKo"
       :name "Rudimental"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:4OTAx9un4e6NfoHuVRiOrC"
      :name "Love In The Future"
      :availability
      {:territories
       "AD AR AT BE CA CH DE EE ES FI FR GB GR HK IE IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "All Of Me"
     :popularity "0.81"
     :external-ids [{:type "isrc" :id "USSM11303954"}]
     :length 269.867
     :href "spotify:track:3U4isOIWM3VvDubwSI3y7a"
     :artists
     [{:href "spotify:artist:5y2Xq6xcjJb2jVM54GHK3t"
       :name "John Legend"}]
     :track-number "6"}
    {:album
     {:released "2004"
      :href "spotify:album:7EXstuWka51pNFzEAidEol"
      :name "Let Me Love You"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR IE IS IT LI LT LU LV MC MX NL NO NZ PL PT SE US"}}
     :name "Let Me Love You"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "USJAY0400348"}]
     :length 257.03
     :href "spotify:track:3ibKnFDaa3GhpPGlOUj7ff"
     :artists
     [{:href "spotify:artist:20s0P9QLxGqKuCsGwFsp7w" :name "Mario"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:1iNfEAZRwc6FjaqbGXO7NF"
      :name "Hard 2 Love"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Hard To Love"
     :popularity "0.73"
     :external-ids [{:type "isrc" :id "USCRB1210131"}]
     :length 220.297
     :href "spotify:track:4J5Ec6Xa2NMtqxLQU7Cnry"
     :artists
     [{:href "spotify:artist:5Zq7R5qmi58ByYyBQTlNuk"
       :name "Lee Brice"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:1lSSMugoU9PoO8XxE5labo"
      :name "Disco Love"
      :availability
      {:territories
       "AD AR AT BE CH DE DK EE ES FI GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SG TR TW"}}
     :name "Disco Love"
     :popularity "0.72"
     :external-ids [{:type "isrc" :id "GBUM71304928"}]
     :length 194.622
     :href "spotify:track:1fXu7DlIwhT65ZcYJFp9LF"
     :artists
     [{:href "spotify:artist:15qI5w4XJFLRMwOp2VrlD5"
       :name "The Saturdays"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:2dVVSzar0cwL96wxEnsbNJ"
      :name "I Love It"
      :availability {:territories "SE"}}
     :name "I Love It"
     :popularity "0.73"
     :external-ids [{:type "isrc" :id "SEWEE1200301"}]
     :length 155.536
     :href "spotify:track:6Ou08NE0N5z8eRL1siDtAK"
     :artists
     [{:href "spotify:artist:1VBflYyxBhnDc9uVib98rw" :name "Icona Pop"}
      {:href "spotify:artist:25uiPmTg16RbhZWAqwLBy5"
       :name "Charli XCX"}]
     :track-number "1"}
    {:album
     {:released "2008"
      :href "spotify:album:3JKLAR3XV8VIFIHagNAR3Y"
      :name "For Emma, Forever Ago"
      :availability {:territories "AD CA DK IS LI MC US"}}
     :name "Skinny Love"
     :popularity "0.76"
     :external-ids [{:type "isrc" :id "US38Y0811503"}]
     :length 238.781
     :href "spotify:track:0zP8BJOamm7Q9aNMwCby55"
     :artists
     [{:href "spotify:artist:4LEiUm1SRbFMgfqnQTwUbQ" :name "Bon Iver"}]
     :track-number "3"}
    {:href "spotify:track:6UaRii9AH6Zss9xNMEQ2M9"
     :track-number "15"
     :artists
     [{:href "spotify:artist:7dGJo4pcD2V6oG8kP0tJRR" :name "Eminem"}
      {:href "spotify:artist:5pKCCKE2ajJHZ9KAiaK11H" :name "Rihanna"}]
     :name "Love The Way You Lie"
     :external-ids [{:type "isrc" :id "USUM71015397"}]
     :explicit true
     :popularity "0.8"
     :length 263.671
     :album
     {:released "2010"
      :href "spotify:album:3PogVmhNucYNfyywZvTd7F"
      :name "Recovery"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}}
    {:album
     {:released "2013"
      :href "spotify:album:5MQBzs5YlZlE28mD9yUItn"
      :name "PRISM"
      :availability {:territories "CA MX US"}}
     :name "Love Me"
     :popularity "0.71"
     :external-ids [{:type "isrc" :id "USUM71311300"}]
     :length 232.951
     :href "spotify:track:2BSFAQuiYKu4VcMjovRgRQ"
     :artists
     [{:href "spotify:artist:6jJ0s89eD6GaHleKKya26X"
       :name "Katy Perry"}]
     :track-number "10"}
    {:album
     {:released "2012"
      :href "spotify:album:5hAJKdlLfFblwwmGR0a3Lk"
      :name "Feel The Love."
      :availability
      {:territories
       "AD AT CA CH DE DK EE ES FI GR IS IT LT LV MC NO NZ PL PT SE TR"}}
     :name "Feel The Love - feat. John Newman"
     :popularity "0.74"
     :external-ids [{:type "isrc" :id "GBAHS1200163"}]
     :length 219.617
     :href "spotify:track:5crHvEPQ13FbQGQSscm5Ns"
     :artists
     [{:href "spotify:artist:4WN5naL3ofxrVBgFpguzKo"
       :name "Rudimental"}]
     :track-number "1"}
    {:href "spotify:track:07EN1w6em5L8Lt3H5ARcSO"
     :track-number "1"
     :artists
     [{:href "spotify:artist:55Aa2cqylxrFIXC767Z865" :name "Lil Wayne"}
      {:href "spotify:artist:3TVXtAsR1Inumwj472S9r4" :name "Drake"}
      {:href "spotify:artist:6TiNbcfVoO3SppeLYJbnSr" :name "Future"}]
     :name "Love Me"
     :external-ids [{:type "isrc" :id "USCM51300001"}]
     :explicit true
     :popularity "0.71"
     :length 255.566
     :album
     {:released "2013"
      :href "spotify:album:4DfNCguyYqOXSyzxuDLc3U"
      :name "Love Me"
      :availability
      {:territories
       "AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LT LU LV MY NL NO NZ PL PT SG TR TW"}}}
    {:album
     {:released "2012"
      :href "spotify:album:1gIC63gC3B7o7FfpPACZQJ"
      :name "4"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Love On Top"
     :popularity "0.76"
     :external-ids [{:type "isrc" :id "USSM11102908"}]
     :length 267.697
     :href "spotify:track:1z6WtY7X4HQJvzxC4UgkSf"
     :artists
     [{:href "spotify:artist:6vWDO969PvNqNYHIOW5v0m" :name "Beyoncé"}]
     :track-number "1"}
    {:href "spotify:track:1Mp36AbVgpubAirlMV0qef"
     :track-number "1"
     :artists
     [{:href "spotify:artist:15iVAtD3s3FsQR4w1v6M0P"
       :name "Chief Keef"}]
     :name "Love Sosa"
     :external-ids [{:type "isrc" :id "USUM71214600"}]
     :explicit true
     :popularity "0.7"
     :length 246.86
     :album
     {:released "2012"
      :href "spotify:album:0L353pS2XMFu4AGlu0sF5r"
      :name "Love Sosa"
      :availability {:territories "CA MX US"}}}
    {:album
     {:released "2012"
      :href "spotify:album:2NfgKzKJkoth02sFUFcBEa"
      :name "Love Is All I Got"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Love Is All I Got"
     :popularity "0.74"
     :external-ids [{:type "isrc" :id "GBTDG1200510"}]
     :length 186.543
     :href "spotify:track:58stjpV04lJKmPgc2vxm6J"
     :artists
     [{:href "spotify:artist:5FWi1mowu6uiU2ZHwr1rby" :name "Feed Me"}
      {:href "spotify:artist:75EZuo5MHV2572NRpMWotC"
       :name "Crystal Fighters"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:5h7fx8ILwOZ3I5yQ4eGBl7"
      :name "The Lumineers"
      :availability
      {:territories
       "AD AR AT BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO PL PT SG TR TW"}}
     :name "Stubborn Love"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "USDMG1260807"}]
     :length 277.632
     :href "spotify:track:15twB7zTglmu0Bg8gW4Mrm"
     :artists
     [{:href "spotify:artist:16oZKvXb6WkQlVAjwo2Wbg"
       :name "The Lumineers"}]
     :track-number "7"}
    {:album
     {:released "2013"
      :href "spotify:album:4lFDt4sVpCni9DRHRmDjgG"
      :name "PRISM"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Love Me"
     :popularity "0.68"
     :external-ids [{:type "isrc" :id "USUM71311300"}]
     :length 232.951
     :href "spotify:track:6KDE7a7bTmOx9ddyeyRnjx"
     :artists
     [{:href "spotify:artist:6jJ0s89eD6GaHleKKya26X"
       :name "Katy Perry"}]
     :track-number "10"}
    {:album
     {:released "2013"
      :href "spotify:album:7xhZwO1E7sSW1YubaUidlS"
      :name "Me Enamore (Feeling of Love)"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Me Enamore (Feeling of Love)"
     :popularity "0.74"
     :external-ids [{:type "isrc" :id "ES18I1340001"}]
     :length 219.957
     :href "spotify:track:4qq8SuhgHd77ZBvLpyuuGh"
     :artists
     [{:href "spotify:artist:2CbZTubQz6tdFmZ3TDUwp7" :name "Xriz"}]
     :track-number "1"}
    {:album
     {:released "2011"
      :href "spotify:album:02pi98kE0nra0yBqCStzbC"
      :name "+"
      :availability {:territories "GB IE LU TR US"}}
     :name "Give Me Love"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "GBAHS1100209"}]
     :length 526.898
     :href "spotify:track:0SuG9kyzGRpDqrCWtgD6Lq"
     :artists
     [{:href "spotify:artist:6eUKZXaKkcviH0Ku9w2n3V"
       :name "Ed Sheeran"}]
     :track-number "12"}
    {:album
     {:released "2009"
      :href "spotify:album:28Nq4AiAa0BW54KGWYFxot"
      :name "Love Story"
      :availability
      {:territories
       "AR AT AU BE CH DE DK EE ES FI GB IE IS IT LT LU LV MY NL NO NZ PT SE SG TR"}}
     :name "Love Story"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USCJY0803447"}]
     :length 235.016
     :href "spotify:track:1JR0kZfJpeNPJKo4HhdQJP"
     :artists
     [{:href "spotify:artist:06HL4z0CvFAxyc27GXpf02"
       :name "Taylor Swift"}]
     :track-number "1"}
    {:album
     {:released "2011"
      :href "spotify:album:3sGzkurA1fvEFqh73sWCVA"
      :name "Birdy"
      :availability
      {:territories
       "AD BE CA DK EE ES FR GR IE LI LT LU LV MC NL NZ PL PT US"}}
     :name "Skinny Love"
     :popularity "0.74"
     :external-ids [{:type "isrc" :id "GBAHS1100350"}]
     :length 203.302
     :href "spotify:track:0HRshWRNAwQBROvxXqG3i9"
     :artists
     [{:href "spotify:artist:2WX2uTcsvV5OnS0inACecP" :name "Birdy"}]
     :track-number "2"}
    {:album
     {:released "2007"
      :href "spotify:album:2Z9WUERfMjOgQ6ze9TcGbF"
      :name "Little Voice"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Love Song"
     :popularity "0.74"
     :external-ids [{:type "isrc" :id "USSM10700066"}]
     :length 259.122
     :href "spotify:track:4E6cwWJWZw2zWf7VFbH7wf"
     :artists
     [{:href "spotify:artist:2Sqr0DXoaYABbjBo9HaMkM"
       :name "Sara Bareilles"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:2rBb9rAEuMC8VH9uk7js3e"
      :name "The Truth About Love"
      :availability {:territories "US"}}
     :name "Just Give Me a Reason"
     :popularity "0.78"
     :external-ids [{:type "isrc" :id "USRC11200786"}]
     :length 243.016
     :href "spotify:track:1qHaLcG3LOeh6ZB8vii5ZZ"
     :artists
     [{:href "spotify:artist:1KCSPY1glIKqW2TotWuXOR" :name "P!nk"}
      {:href "spotify:artist:1qUjOF5fzrpoNycD36b2jZ"
       :name "Nate Ruess"}]
     :track-number "4"}
    {:album
     {:released "2011"
      :href "spotify:album:68Dq0YFgygP4ipCUKCeKqE"
      :name "Best Love Song"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Best Love Song"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USJI11100073"}]
     :length 197.838
     :href "spotify:track:133g7oJWqvMnhvwfXL4CU1"
     :artists
     [{:href "spotify:artist:3aQeKQSyrW4qWr35idm0cy" :name "T-Pain"}
      {:href "spotify:artist:7bXgB6jMjp9ATFy66eO08Z"
       :name "Chris Brown"}]
     :track-number "1"}
    {:album
     {:released "2010"
      :href "spotify:album:2a4iBWsCvhTmnWziQV2qQ6"
      :name "Love Like Crazy"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Love Like Crazy"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USCRB0908925"}]
     :length 217.551
     :href "spotify:track:0h3NhK4lkyQwQqAqNQJIIJ"
     :artists
     [{:href "spotify:artist:5Zq7R5qmi58ByYyBQTlNuk"
       :name "Lee Brice"}]
     :track-number "2"}
    {:album
     {:released "2011"
      :href "spotify:album:02GFLugkFRP86wz05s4DmW"
      :name "We Found Love"
      :availability {:territories "CA MX US"}}
     :name "We Found Love"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USUM71115507"}]
     :length 216.009
     :href "spotify:track:1bLG2x4ePXBr6TXFBOmXRk"
     :artists
     [{:href "spotify:artist:5pKCCKE2ajJHZ9KAiaK11H" :name "Rihanna"}
      {:href "spotify:artist:7CajNmpbOovFoOoasH2HaY"
       :name "Calvin Harris"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:6uD3oJCWT1gtlSCg5lDiNF"
      :name "My Head Is An Animal"
      :availability {:territories "CA MX US"}}
     :name "Love Love Love"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USUM71119282"}]
     :length 239.069
     :href "spotify:track:15IWqq4MaJ09ZQZgzcbn4p"
     :artists
     [{:href "spotify:artist:4dwdTW1Lfiq0cM8nBAqIIz"
       :name "Of Monsters And Men"}]
     :track-number "8"}
    {:album
     {:released "1993"
      :href "spotify:album:0qTVjeVP70YvQG4GctetOf"
      :name "What is Love - Remix"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW"}}
     :name "What Is Love"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "DEA410500401"}]
     :length 270.678
     :href "spotify:track:2ahnofp2LbBWDXcJbMaSTu"
     :artists
     [{:href "spotify:artist:0Suv0tRrNrUlRzAy8aXjma" :name "Haddaway"}]
     :track-number "3"}
    {:album
     {:released "2011"
      :href "spotify:album:2MxcbOGFi99D9JACvj74AH"
      :name "Every Kingdom"
      :availability {:territories "DE DK ES FI GB IE NO NZ SE"}}
     :name "Only Love"
     :popularity "0.73"
     :external-ids [{:type "isrc" :id "GBUM71104742"}]
     :length 249.448
     :href "spotify:track:3MdYFBIzPf7lSJnI8wi3Ka"
     :artists
     [{:href "spotify:artist:5schNIzWdI9gJ1QRK8SBnc"
       :name "Ben Howard"}]
     :track-number "5"}
    {:album
     {:released "2013"
      :href "spotify:album:3jB9yFDwRe3KhtGnHXJntk"
      :name "PRISM"
      :availability {:territories "CA MX US"}}
     :name "Love Me"
     :popularity "0.58"
     :external-ids [{:type "isrc" :id "USUM71311300"}]
     :length 232.951
     :href "spotify:track:2lrMNui7pK7P7KDWrp86Ru"
     :artists
     [{:href "spotify:artist:6jJ0s89eD6GaHleKKya26X"
       :name "Katy Perry"}]
     :track-number "10"}
    {:album
     {:released "2013"
      :href "spotify:album:6GVRj7AKMs20GLMrU5F51S"
      :name "Hey Love"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Hey Love"
     :popularity "0.68"
     :external-ids [{:type "isrc" :id "USSM11300676"}]
     :length 203.119
     :href "spotify:track:5ZBuMXIDBibznpfhgraoul"
     :artists
     [{:href "spotify:artist:3GhVFlFT3pagjVkslQPqoJ" :name "Quadron"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:0JLLn5vaJZecVH0lTEsDXP"
      :name "Overexposed"
      :availability
      {:territories
       "AD AR AT AU BE CH DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Love Somebody"
     :popularity "0.73"
     :external-ids [{:type "isrc" :id "USUM71204774"}]
     :length 230.101
     :href "spotify:track:3ISTk34XFWxJJnUs5youLa"
     :artists
     [{:href "spotify:artist:04gDigrS5kc9YWfZHwBETP" :name "Maroon 5"}]
     :track-number "6"}
    {:album
     {:released "2013"
      :href "spotify:album:46ZM3XlLhd3rHbExzXRDbr"
      :name "Love Me Again"
      :availability {:territories "CA US"}}
     :name "Love Me Again"
     :popularity "0.69"
     :external-ids [{:type "isrc" :id "GBUM71301538"}]
     :length 240.167
     :href "spotify:track:7v6EVHw0iUL8ww77IaoLCZ"
     :artists
     [{:href "spotify:artist:34v5MVKeQnIo0CWYMbbrPf"
       :name "John Newman"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:4m2880jivSbbyEGAKfITCa"
      :name "Random Access Memories"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "The Game of Love"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "USQX91300102"}]
     :length 322.497
     :href "spotify:track:3ctALmweZBapfBdFiIVpji"
     :artists
     [{:href "spotify:artist:4tZwfgrHOc3mvqYlEYSvVi"
       :name "Daft Punk"}]
     :track-number "2"}
    {:href "spotify:track:7brQHA2CgQpcMBiOlfiXYb"
     :track-number "2"
     :artists
     [{:href "spotify:artist:77SW9BnxLY8rJ0RciFqkHh"
       :name "The Neighbourhood"}]
     :name "Afraid"
     :external-ids [{:type "isrc" :id "USSM11300889"}]
     :explicit true
     :popularity "0.75"
     :length 251.461
     :album
     {:released "2013"
      :href "spotify:album:4xkM0BwLM9H2IUcbYzpcBI"
      :name "I Love You."
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GR HK IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}}
    {:album
     {:released "2013"
      :href "spotify:album:5szxmEfjHdrXxMtX2uMExs"
      :name "PRISM"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SG TR TW"}}
     :name "Love Me"
     :popularity "0.52"
     :external-ids [{:type "isrc" :id "USUM71311300"}]
     :length 232.951
     :href "spotify:track:2CztIoCSPgfQSiSVhQrWTe"
     :artists
     [{:href "spotify:artist:6jJ0s89eD6GaHleKKya26X"
       :name "Katy Perry"}]
     :track-number "10"}
    {:album
     {:released "2012"
      :href "spotify:album:7w19PFbxAjwZ7UVNp9z0uT"
      :name "18 Months"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "We Found Love"
     :popularity "0.73"
     :external-ids [{:type "isrc" :id "GBARL1201387"}]
     :length 215.773
     :href "spotify:track:0385HqYimoTQaHZP17KwG1"
     :artists
     [{:href "spotify:artist:7CajNmpbOovFoOoasH2HaY"
       :name "Calvin Harris"}
      {:href "spotify:artist:5pKCCKE2ajJHZ9KAiaK11H" :name "Rihanna"}]
     :track-number "4"}
    {:album
     {:released "2011"
      :href "spotify:album:3Q5InprPfd8bJjWvMcf0G8"
      :name "How To Love"
      :availability {:territories "CA MX US"}}
     :name "How To Love"
     :popularity "0.69"
     :external-ids [{:type "isrc" :id "USCM51100147"}]
     :length 244.664
     :href "spotify:track:5txZAE3yuzpwfwuIa1AwJc"
     :artists
     [{:href "spotify:artist:55Aa2cqylxrFIXC767Z865"
       :name "Lil Wayne"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:0UW4Mmk8L9SatcXiqL91rX"
      :name "What About Love"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "What About Love"
     :popularity "0.69"
     :external-ids [{:type "isrc" :id "USCM51300447"}]
     :length 203.982
     :href "spotify:track:7h0UYZxGLiy0UCWGU1eaVF"
     :artists
     [{:href "spotify:artist:04abdnqPQe2N4fjztDea6z"
       :name "Austin Mahone"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:6mdbwD2OEFexB0lPXoRofQ"
      :name "Love and Theft"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Angel Eyes"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USRN11100128"}]
     :length 186.857
     :href "spotify:track:63w0QA1wiV7QhF9jeiHETF"
     :artists
     [{:href "spotify:artist:03a5eVjzFyQlR4XyVSwt4t"
       :name "Love and Theft"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:4p9dVvZDaZliSjTCbFRhJy"
      :name "My Head Is An Animal"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Love Love Love"
     :popularity "0.69"
     :external-ids [{:type "isrc" :id "USUM71119282"}]
     :length 239.069
     :href "spotify:track:3o1cohFfwd57rAvrbyVE5e"
     :artists
     [{:href "spotify:artist:4dwdTW1Lfiq0cM8nBAqIIz"
       :name "Of Monsters And Men"}]
     :track-number "8"}
    {:album
     {:released "2012"
      :href "spotify:album:0MYABBSxz6JqujXq2JBvsF"
      :name "Talk That Talk"
      :availability
      {:territories
       "AD AR AT BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO PL PT SE SG TR TW"}}
     :name "We Found Love"
     :popularity "0.73"
     :external-ids [{:type "isrc" :id "USUM71115507"}]
     :length 215.486
     :href "spotify:track:5uImkHXfTLkNYwemtGH7kB"
     :artists
     [{:href "spotify:artist:5pKCCKE2ajJHZ9KAiaK11H" :name "Rihanna"}
      {:href "spotify:artist:7CajNmpbOovFoOoasH2HaY"
       :name "Calvin Harris"}]
     :track-number "3"}
    {:album
     {:released "2012"
      :href "spotify:album:0pqKb2y8h2BWS46HMfmEgD"
      :name "The Truth About Love"
      :availability {:territories "AR CA HK MX MY SG TW US"}}
     :name "Just Give Me a Reason"
     :popularity "0.76"
     :external-ids [{:type "isrc" :id "USRC11200786"}]
     :length 243.016
     :href "spotify:track:4VC5nFbYO4avKksJ9jN4pY"
     :artists
     [{:href "spotify:artist:1KCSPY1glIKqW2TotWuXOR" :name "P!nk"}
      {:href "spotify:artist:1qUjOF5fzrpoNycD36b2jZ"
       :name "Nate Ruess"}]
     :track-number "4"}
    {:album
     {:released "2012"
      :href "spotify:album:6XO9dbsH9zhuQgFGH0hUrb"
      :name "The Heist"
      :availability
      {:territories
       "AD AT AU BE CA CH DE DK EE ES FI FR GB GR IE IS IT LI LT LU LV MC NL NO NZ PL PT SE TR US"}}
     :name "Same Love - feat. Mary Lambert"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "GMM881200005"}]
     :length 320.379
     :href "spotify:track:6IFa4RUo2iM5L33Hkx82lr"
     :artists
     [{:href "spotify:artist:5BcAKTbp20cv7tC5VqPFoC"
       :name "Macklemore & Ryan Lewis"}]
     :track-number "5"}
    {:album
     {:released "2012"
      :href "spotify:album:33HjgKPNuu4pYcTzAShz2i"
      :name "Early in the Morning (Special Edition)"
      :availability
      {:territories
       "AD AT BE CH DE DK EE ES FI FR GB GR IE IS IT LI LT LU LV MC NL NO PL PT SE TR"}}
     :name "Higher Love"
     :popularity "0.71"
     :external-ids [{:type "isrc" :id "IEDNV1100039"}]
     :length 215.852
     :href "spotify:track:7apw8m9lHQjvuUVfMAm4kZ"
     :artists
     [{:href "spotify:artist:7FDlvgcodNfC0IBdWevl4u"
       :name "James Vincent McMorrow"}]
     :track-number "12"}
    {:href "spotify:track:0TiC3GtlMCskf2hIUIBcDV"
     :track-number "4"
     :artists
     [{:href "spotify:artist:3TVXtAsR1Inumwj472S9r4" :name "Drake"}
      {:href "spotify:artist:1Xyo4u8uXC1ZmMpatF05PJ"
       :name "The Weeknd"}]
     :name "Crew Love"
     :external-ids [{:type "isrc" :id "USCM51100546"}]
     :explicit true
     :popularity "0.71"
     :length 209.054
     :album
     {:released "2011"
      :href "spotify:album:63WdJvk8G9hxJn8u5rswNh"
      :name "Take Care"
      :availability {:territories "CA MX US"}}}
    {:album
     {:released "2012"
      :href "spotify:album:5SxEsi1PNyo1XfEKDYcFKF"
      :name "Take Me Home: Yearbook Edition"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Summer Love"
     :popularity "0.71"
     :external-ids [{:type "isrc" :id "GBHMU1200373"}]
     :length 208.453
     :href "spotify:track:2LjmbI7LJt0RDg612cBi7U"
     :artists
     [{:href "spotify:artist:4AK6F7OLvEQ5QYCBNiQWHq"
       :name "One Direction"}]
     :track-number "13"}
    {:album
     {:released "2001"
      :href "spotify:album:7mQySyLxOukXItkdPBs90U"
      :name "First Love (Yiruma Piano Collection)"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "River Flows In You - Original"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "HKOA10616988"}]
     :length 185.759
     :href "spotify:track:47ZWr1Nb0PUgmKgyg5JkgO"
     :artists
     [{:href "spotify:artist:0fauHpmSHwodVYIjTqOGHz" :name "Yiruma"}]
     :track-number "4"}
    {:album
     {:released "2013"
      :href "spotify:album:41br7lBSZOr9RjJAjk0om6"
      :name "The 20/20 Experience"
      :availability {:territories "US"}}
     :name "Pusher Love Girl"
     :popularity "0.72"
     :external-ids [{:type "isrc" :id "USRC11300060"}]
     :length 482.844
     :href "spotify:track:4tVEJTR4VgBvvb2R6phA2v"
     :artists
     [{:href "spotify:artist:31TPClRtHm23RisEBtV3X7"
       :name "Justin Timberlake"}]
     :track-number "1"}
    {:album
     {:released "2009"
      :href "spotify:album:3MXDonOIzrIrCh0HvlACyj"
      :name "Crazy Love"
      :availability
      {:territories
       "AD AT AU BE CA CH DE DK EE ES FI FR GB GR IE IS IT LT LU LV MC NL NO NZ PL PT SE TR US"}}
     :name "Haven't Met You Yet"
     :popularity "0.72"
     :external-ids [{:type "isrc" :id "USRE10901437"}]
     :length 244.873
     :href "spotify:track:4fIWvT19w9PR0VVBuPYpWA"
     :artists
     [{:href "spotify:artist:1GxkXlMwML1oSg5eLPiAz3"
       :name "Michael Bublé"}]
     :track-number "5"}
    {:album
     {:released "2008"
      :href "spotify:album:0zMOz1phwhxqDqNzttMXsw"
      :name "My Love Essential Collection"
      :availability
      {:territories
       "AD AT BE CH DE DK EE ES FI FR GB GR IE IS IT LI LT LU LV MC NL NO PL PT SE TR"}}
     :name "My Heart Will Go On (Love Theme from \"Titanic\")"
     :popularity "0.71"
     :external-ids [{:type "isrc" :id "CAC229700120"}]
     :length 281.554
     :href "spotify:track:0sGNcx6lfc3zrbiIOxY4vb"
     :artists
     [{:href "spotify:artist:4S9EykWXhStSc15wEx8QFK"
       :name "Céline Dion"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:1iNfEAZRwc6FjaqbGXO7NF"
      :name "Hard 2 Love"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Parking Lot Party"
     :popularity "0.73"
     :external-ids [{:type "isrc" :id "USCRB1210133"}]
     :length 208.139
     :href "spotify:track:2dvYQFo0yEASDUIQmcfyM0"
     :artists
     [{:href "spotify:artist:5Zq7R5qmi58ByYyBQTlNuk"
       :name "Lee Brice"}]
     :track-number "4"}
    {:album
     {:released "2012"
      :href "spotify:album:3IqZoTqfNBZtGDQLFRHBAR"
      :name "Let Me Love You (Until You Learn To Love Yourself)"
      :availability
      {:territories
       "AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LT LU LV MY NL NO NZ PL PT SG TR TW"}}
     :name "Let Me Love You (Until You Learn To Love Yourself)"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USUM71207198"}]
     :length 254.39
     :href "spotify:track:68PHBS4CsrBK8QnRmeGqup"
     :artists
     [{:href "spotify:artist:21E3waRsmPlU7jZsS13rcj" :name "Ne-Yo"}]
     :track-number "1"}
    {:href "spotify:track:6ievPGLJVOHtizroTE9VfT"
     :track-number "1"
     :artists
     [{:href "spotify:artist:5LHRHt1k9lMyONurDHEdrp" :name "Tyga"}]
     :name "Cali Love"
     :external-ids [{:type "isrc" :id "USQY50929626"}]
     :explicit true
     :popularity "0.66"
     :length 229.421
     :album
     {:released "2009"
      :href "spotify:album:3QYfzR7VQOC0Y1adZZv5P2"
      :name "Cali Love"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}}
    {:album
     {:released "2013"
      :href "spotify:album:3fUjcM4btDz8iDT651n5Cq"
      :name "Love More"
      :availability
      {:territories
       "AD AR AU BE CA CH EE ES FI FR GB GR HK IE IT LI LT LU LV MC MX MY NL NZ PL PT SG TR TW US"}}
     :name "Love More"
     :popularity "0.66"
     :external-ids [{:type "isrc" :id "USRC11300978"}]
     :length 190.204
     :href "spotify:track:1l4XkC3igqmgJEcxjnsA3S"
     :artists
     [{:href "spotify:artist:7bXgB6jMjp9ATFy66eO08Z"
       :name "Chris Brown"}
      {:href "spotify:artist:0hCNtLu0JehylgoiP8L4Gh"
       :name "Nicki Minaj"}]
     :track-number "1"}
    {:album
     {:released "2011"
      :href "spotify:album:7uBuYyYk5LXQ1GsTWYGm4r"
      :name "How To Love"
      :availability
      {:territories
       "AR AT AU BE DE DK EE FI FR GB HK IE IS IT LT LU LV MY NL NO NZ PL PT SG TR TW"}}
     :name "How To Love"
     :popularity "0.67"
     :external-ids [{:type "isrc" :id "USCM51100147"}]
     :length 244.664
     :href "spotify:track:19xHOPju4WdsErvJo0gJHc"
     :artists
     [{:href "spotify:artist:55Aa2cqylxrFIXC767Z865"
       :name "Lil Wayne"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:39h0PMiDnWXboQBCwvn60E"
      :name "Let Me Love You (Until You Learn To Love Yourself)"
      :availability {:territories "CA MX US"}}
     :name "Let Me Love You (Until You Learn To Love Yourself)"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USUM71207198"}]
     :length 254.39
     :href "spotify:track:7lJUnNQC5IX4f2OwH23cBF"
     :artists
     [{:href "spotify:artist:21E3waRsmPlU7jZsS13rcj" :name "Ne-Yo"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:4MGDyHLc9ctHHiX4wCn1tV"
      :name "Stars Dance"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Love Will Remember"
     :popularity "0.72"
     :external-ids [{:type "isrc" :id "USHR11334537"}]
     :length 210.597
     :href "spotify:track:0kAv1wGVCGPIHEH1hFJNcG"
     :artists
     [{:href "spotify:artist:0C8ZW7ezQVs4URX5aX7Kqx"
       :name "Selena Gomez"}]
     :track-number "11"}
    {:album
     {:released "2013"
      :href "spotify:album:0VQBlipDNIzyiIMBE9OsO2"
      :name "What About Love"
      :availability {:territories "CA MX US"}}
     :name "What About Love"
     :popularity "0.67"
     :external-ids [{:type "isrc" :id "USCM51300447"}]
     :length 203.982
     :href "spotify:track:4uWUGGzAvIlvqE8KQ74gs8"
     :artists
     [{:href "spotify:artist:04abdnqPQe2N4fjztDea6z"
       :name "Austin Mahone"}]
     :track-number "1"}
    {:href "spotify:track:52JyHLUiugFECIYBWM2qdh"
     :track-number "9"
     :artists
     [{:href "spotify:artist:7dGJo4pcD2V6oG8kP0tJRR" :name "Eminem"}
      {:href "spotify:artist:55Aa2cqylxrFIXC767Z865"
       :name "Lil Wayne"}]
     :name "No Love"
     :external-ids [{:type "isrc" :id "USUM71015393"}]
     :explicit true
     :popularity "0.71"
     :length 299.829
     :album
     {:released "2010"
      :href "spotify:album:3PogVmhNucYNfyywZvTd7F"
      :name "Recovery"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}}
    {:album
     {:released "2012"
      :href "spotify:album:7BWK3eXcbAdwYeulyQj5Kw"
      :name "Believe"
      :availability
      {:territories
       "AT AU BE CH DE DK ES FI FR GB HK MY NL NO NZ PT SE SG TW"}}
     :name "As Long As You Love Me"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "USUM71205320"}]
     :length 229.735
     :href "spotify:track:4rvtlpAeDuOn4baUJPCEhy"
     :artists
     [{:href "spotify:artist:1uNFoZAHBGtllmzznpCI3s"
       :name "Justin Bieber"}
      {:href "spotify:artist:0c173mlxpT3dSFRgMO8XPh" :name "Big Sean"}]
     :track-number "3"}
    {:album
     {:released "2008"
      :href "spotify:album:7t1veDv7FWHYXskQEoU7dq"
      :name "Spirit"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Bleeding Love"
     :popularity "0.71"
     :external-ids [{:type "isrc" :id "GBHMU0700049"}]
     :length 262.991
     :href "spotify:track:6LtPIXlIzPOTF8vTecYjRe"
     :artists
     [{:href "spotify:artist:5lKZWd6HiSCLfnDGrq9RAm"
       :name "Leona Lewis"}]
     :track-number "1"}
    {:album
     {:released "2008"
      :href "spotify:album:2YO1F9DHVEzXPriA1JHoOQ"
      :name "19"
      :availability
      {:territories
       "AD AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Make You Feel My Love (album)"
     :popularity "0.75"
     :external-ids [{:type "isrc" :id "GBBKS0700586"}]
     :length 212.296
     :href "spotify:track:0mqTcM8kuu2IYPotMt7AzS"
     :artists
     [{:href "spotify:artist:4dpARuHxo51G3z768sgnrY" :name "Adele"}]
     :track-number "9"}
    {:album
     {:released "1998"
      :href "spotify:album:5FfkiNcXAvagExRCLd8nn4"
      :name "Super Hits"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Your Love"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USSM18500264"}]
     :length 222.101
     :href "spotify:track:5dRQUolXAVX3BbCiIxmSsf"
     :artists
     [{:href "spotify:artist:1zxDewzd2j1ZdSBGaYcr0y"
       :name "The Outfield"}]
     :track-number "5"}
    {:album
     {:released "2009"
      :href "spotify:album:2PPFtYUnnqMYflIEn3b7ON"
      :name "I And Love And You"
      :availability {:territories "CA MX US"}}
     :name "I And Love And You"
     :popularity "0.69"
     :external-ids [{:type "isrc" :id "USSM10903395"}]
     :length 301.163
     :href "spotify:track:7CEV9VwA8XO9wwxTXgYKvY"
     :artists
     [{:href "spotify:artist:196lKsA13K3keVXMDFK66q"
       :name "The Avett Brothers"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:7bCDE4ddc9T8Zkw588bN73"
      :name "Love Me Again"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Love Me Again - Kove Remix"
     :popularity "0.68"
     :external-ids [{:type "isrc" :id "GBUM71302817"}]
     :length 260.952
     :href "spotify:track:7oIie45AkGl7IA4yBu898V"
     :artists
     [{:href "spotify:artist:34v5MVKeQnIo0CWYMbbrPf"
       :name "John Newman"}]
     :track-number "2"}
    {:album
     {:released "2004"
      :href "spotify:album:0TGTGuc2vXv6ZECoAf52N0"
      :name "Good News For People Who Love Bad News"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "Float On"
     :popularity "0.76"
     :external-ids [{:type "isrc" :id "USSM10315494"}]
     :length 208.714
     :href "spotify:track:2lwwrWVKdf3LR9lbbhnr6R"
     :artists
     [{:href "spotify:artist:1yAwtBaoHLEDWAnWR87hBT"
       :name "Modest Mouse"}]
     :track-number "3"}
    {:album
     {:released "2013"
      :href "spotify:album:1I7nurs0QFuIrDPXjdx96L"
      :name "Loud Like Love"
      :availability
      {:territories
       "AD AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MY NL NO NZ PL PT SE SG TR TW"}}
     :name "Loud Like Love"
     :popularity "0.67"
     :external-ids [{:type "isrc" :id "DEUM71301907"}]
     :length 292.038
     :href "spotify:track:5hxuBWWmk9cGM1p8vrJ8bP"
     :artists
     [{:href "spotify:artist:6RZUqkomCmb8zCRqc9eznB" :name "Placebo"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:53rR6zjaUDjeWlUveFMSjE"
      :name "The Love Club EP"
      :availability {:territories "CA MX US"}}
     :name "Bravado"
     :popularity "0.74"
     :external-ids [{:type "isrc" :id "NZUM71200030"}]
     :length 221.656
     :href "spotify:track:4LyayEtnon3IDPHP6NoIjH"
     :artists
     [{:href "spotify:artist:163tK9Wjr9P9DmM0AVK7lm" :name "Lorde"}]
     :track-number "1"}
    {:album
     {:released "2012"
      :href "spotify:album:7LXJ2yXkwZ1RmS4JHKzg0g"
      :name "We Love Green"
      :availability
      {:territories
       "AD AR AT AU BE CA CH DE DK EE ES FI FR GB GR HK IE IS IT LI LT LU LV MC MX MY NL NO NZ PL PT SE SG TR TW US"}}
     :name "This Head I Hold"
     :popularity "0.73"
     :external-ids [{:type "isrc" :id "USCJ81100776"}]
     :length 175.981
     :href "spotify:track:74reD6Vha9tSy1ReFmyW40"
     :artists
     [{:href "spotify:artist:7sgWBYtJpblXpJl2lU5WVs"
       :name "Electric Guest"}]
     :track-number "1"}
    {:album
     {:released "2013"
      :href "spotify:album:53rR6zjaUDjeWlUveFMSjE"
      :name "The Love Club EP"
      :availability {:territories "CA MX US"}}
     :name "Million Dollar Bills"
     :popularity "0.74"
     :external-ids [{:type "isrc" :id "NZUM71200033"}]
     :length 138.411
     :href "spotify:track:4YGYlQnyLPvxEuPxMDQaol"
     :artists
     [{:href "spotify:artist:163tK9Wjr9P9DmM0AVK7lm" :name "Lorde"}]
     :track-number "3"}
    {:href "spotify:track:15JINEqzVMv3SvJTAXAKED"
     :track-number "15"
     :artists
     [{:href "spotify:artist:7dGJo4pcD2V6oG8kP0tJRR" :name "Eminem"}
      {:href "spotify:artist:5pKCCKE2ajJHZ9KAiaK11H" :name "Rihanna"}]
     :name "Love The Way You Lie"
     :external-ids [{:type "isrc" :id "USUM71015397"}]
     :explicit true
     :popularity "0.74"
     :length 263.671
     :album
     {:released "2010"
      :href "spotify:album:47BiFcV59TQi2s9SkBo2pb"
      :name "Recovery"
      :availability {:territories "CA MX US"}}}
    {:album
     {:released "2007"
      :href "spotify:album:1Rv9WRKyYhFaGbuYDaQunN"
      :name "Songs About Jane"
      :availability {:territories "CA MX US"}}
     :name "This Love"
     :popularity "0.7"
     :external-ids [{:type "isrc" :id "USJAY0300080"}]
     :length 206.44
     :href "spotify:track:6YgV0EF8xJMZz0Zm6BTaT4"
     :artists
     [{:href "spotify:artist:04gDigrS5kc9YWfZHwBETP" :name "Maroon 5"}]
     :track-number "2"}
    {:album
     {:released "2011"
      :href "spotify:album:0W5GGnapMz0VwemQvJDqa7"
      :name "+"
      :availability
      {:territories
       "AT AU BE CH DE EE ES FR GR IE IT LT LU LV NL NO NZ PL PT TR US"}}
     :name "Give Me Love"
     :popularity "0.71"
     :external-ids [{:type "isrc" :id "GBAHS1100209"}]
     :length 526.898
     :href "spotify:track:1NvOOkafczKxO5YXRR01ax"
     :artists
     [{:href "spotify:artist:6eUKZXaKkcviH0Ku9w2n3V"
       :name "Ed Sheeran"}]
     :track-number "12"}
    {:album
     {:released "2010"
      :href "spotify:album:2OhS8YOLjwnEqj0cwMMj6W"
      :name "Limit To Your Love"
      :availability
      {:territories
       "AR AT AU BE CH DE DK EE ES FI FR GB GR HK IE IS IT LT LU LV MY NL NO NZ PL PT SG TR TW"}}
     :name "Limit To Your Love"
     :popularity "0.68"
     :external-ids [{:type "isrc" :id "GBUM71028665"}]
     :length 277.659
     :href "spotify:track:5wZbNyht0kr3Tu8BkW4hux"
     :artists
     [{:href "spotify:artist:53KwLdlmrlCelAZMaLVZqU"
       :name "James Blake"}]
     :track-number "1"}]})

(defn query-spotify
  "Run an arbitrary query agains Spotify's API."
  [query]
  (parse-string (:body (http/get "http://ws.spotify.com/search/1/track.json"
                                 {:query-params {:q query}}))
                true))
