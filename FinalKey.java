//#4 
        public void retainAll(Set<Integer> s1, Set<Integer> s2) {
            Iterator<Integer> i = s1.iterator();
            while (i.hasNext()) {
                if (!s2.contains(i.next())) {
                    i.remove();
                }
            }
        }

//#5
        public int purebredOdds() {
            return purebredOdds(overallRoot);
        }

        private int purebredOdds(IntTreeNode root) {
            if (root == null || root.data % 2 == 0)
                return 0;
            else
                return 1 + purebredOdds(root.left) + purebredOdds(root.right);
        }

//#6
        public static Map<Point, Integer> sumStrings(Map<String, Point> data) {
            Map<Point, Integer> result = new HashMap<Point, Integer>();
            for (String s : data.keySet()) {
                Point p = data.get(s);
                if (!result.containsKey(p)) {
                    result.put(p, s.length());
                } else {
                    result.put(p, result.get(p) + s.length());
                }
            }  
             return result;
        }

//#7
        public class RadioStation implements Comparable<RadioStation> {
            private String name;
            private String band;
            private double station;
            private RadioStation link;
        
            public RadioStation(String name, String band, double station) {
                this.name = name;
                this.band = band;
                this.station = station;
            }
        
            public int compareTo(RadioStation other) {
                if (!band.equals(other.band))
                    return band.compareTo(other.band);
                double difference = station - other.station;
                if (difference < 0)
                    return -1;
                else if (difference == 0)
                    return 0;
                else // difference > 0
                    return 1;
            }
        
            public String getName() {
                return name;
            }
        
            public String getBand() {
                return band;
            }
        
            public double getStation() {
                return station;
            }
        
            public void simulcast(RadioStation other) {
                link = other;
                other.link = this;
            }
        
            public String toString() {
                String result = name + " " + band + " " + station;
                if (link != null)
                    result += " (simulcast on " + link.band + " " + 
                              link.station + ")";
                return result;
            }
        }

//#8
        public void trim(int min, int max) {
            overallRoot = trim(overallRoot, min, max);
        }   

        private IntTreeNode trim(IntTreeNode node, int min, int max) {
            if (node == null) {
                return null;
            } else if(node.data < min) {
                return trim(node.right, min, max);
            } else if(node.data > max) {
                return trim(node.left, min, max);
            }
            node.left = trim(node.left, min, max);
            node.right = trim(node.right, min, max);
            return node;
        }

//#9
        public void mergeFrom(LinkedIntList other) {
            if (other.front != null) {
                if (front == null)
                    front = other.front;
                else {
                    ListNode current1 = front;
                    ListNode current2 = other.front;

                    if (front.data <= other.front.data) {
                        current1 = current1.next;
                    } else {
                        front = other.front;
                        current2 = current2.next;
                    }
                    ListNode current3 = front;
                    while (current1 != null && current2 != null) {
                        if (current1.data <= current2.data) {
                            current3.next = current1;
                            current1 = current1.next;
                        } else {
                            current3.next = current2;
                            current2 = current2.next;
                        }
                        current3 = current3.next;
                    }
                    if (current1 != null) {
                        current3.next = current1;
                    } else {
                        current3.next = current2;
                    }
                }
                other.front = null;
            }
        }
