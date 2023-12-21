// Baraka Hanggi
// Project 3

package student;

import provided.BinarySequence;

public class HuffmanCodeBook {
    /** Custom SortedMap object that maps Characters and BinarySequences in sorted order.*/
    private SortedMap<Character, BinarySequence> codeBook;

    /**
     * Private class for mapping Characters to BinarySequences in a sorted Array.
     * @param <K> - generic Key value (must be comparable).
     * @param <V> - generic value associated with a key.
     */
    private class SortedMap<K  extends Comparable<K>, V> {

        /** Array of Keys and Values. */
        private Entry<K, V>[] entryList;

        /**
         * Private class for Mapping Keys and Values.
         * @param <K> - generic key value.
         * @param <V> - generic value associated with a key.
         */
        private class Entry<K, V> {
            /** Generic Key Value. */
            private K key;
            /** Generic Value. */
            private V value;

            /**
             * Constructor for a single entry.
             * @param key - Key Value.
             * @param value - Value associated with Key.
             */
            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        /** Constructors a Entry Array (SortedMap) with Length 0 (Empty). */
        public SortedMap() {
            entryList = new Entry[0];
        }

        /**
         * @return length of entryList.
         */
        public int getLength() {
            return entryList.length;
        }

        /**
         * Returns key at index position i.
         * @param i - index position.
         * @return K object, Key value.
         */
        public K getKey(int i) {
            return entryList[i].key;
        }

        /**
         * Inserts a key, value pair into the SortedMap at a given index.
         * @param key - Key Value of the Entry.
         * @param value - Value associated with the key value.
         * @param i - Index for object to be inserted.
         */
        private void insert(K key, V value, int i) {
            if (i > entryList.length || i < 0) {
                return;
            }
            Entry<K, V>[] newEntryList = new Entry[entryList.length + 1];
            int k = 0;
            for (int j = 0; j < newEntryList.length; j++) {
                if (j == i) {
                    continue;
                }

                newEntryList[j] = entryList[k];
                k++;
            }
            newEntryList[i] = new Entry<K, V>(key, value);
            entryList = newEntryList;
        }

        /**
         * Inserts a key, value pair into the SortedMap (sorted through Keys).
         * @param key - Key Value of the entry.
         * @param value - Value associated with the Key value.
         */
        public void put(K key, V value) {
            if (entryList.length == 0) {
                insert(key, value, 0);
            } else {
                int l = 0;
                int r = entryList.length - 1;
                while (l <= r) {
                    int mid = (int) (l + r) / 2;
                    if (l == r && entryList[mid].key.compareTo(key) < 0) {
                        insert(key, value, mid + 1);
                        break;
                    } else if (l == r && entryList[mid].key.compareTo(key) > 0) {
                        insert(key, value, mid);
                        break;
                    } else if (entryList[mid].key.compareTo(key) < 0) {
                        l = mid + 1;
                    } else if (entryList[mid].key.compareTo(key) > 0) {
                        r = mid;
                    } else {
                        entryList[mid].value = value;
                    }
                }
            }
        }

        /**
         * Returns the Value associated with a Key.
         * @param key - Key value to be searched for.
         * @return V object, value associated with the key.
         */
        public V get(K key) {
            int l = 0;
            int r = entryList.length - 1;

            while (l <= r) {
                int mid = (int) Math.floor((l + r) / 2);
                if (entryList[mid].key.compareTo(key) < 0) {
                    l = mid + 1;
                } else if (entryList[mid].key.compareTo(key) > 0) {
                    r = mid - 1;
                } else if (entryList[mid].key.compareTo(key) == 0) {
                    return entryList[mid].value;
                }
            }
            return null;
        }


    }

    /** Constructs a codeBook (SortedMap).  */
    public HuffmanCodeBook() {
        codeBook = new SortedMap<>();
    }

    /**
     * Adds a character,BinarySequence pair into the codeBook.
     * @param c - character in the pair.
     * @param seq - BinarySequence in the pair.
     */
    public void addSequence(char c, BinarySequence seq) {
        codeBook.put(c, seq);
    }

    /**
     * Checks if codeBook contains a character.
     * @param letter - character to be searched for in the codeBook
     * @return boolean value, true if the codeBook contains character, false otherwise.
     */
    public boolean contains(char letter) {
        if (codeBook.get(letter) != null) {
            return true;
        }
        return false;
    }

    /**
     * Checks if every character in a string is in the codeBook.
     * @param letters - String of characters to be searched for.
     * @return boolean value, true if all characters are in the codeBook.
     */
    public boolean containsAll(String letters) {
        for (int i = 0; i < letters.length(); i++) {
            if (!contains(letters.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the BinarySequence associated with a character.
     * @param c - character to be searched for.
     * @return BinarySequence assoicated with the character.
     */
    public BinarySequence getSequence(char c) {
        return codeBook.get(c);
    }

    /**
     * Encodes a string into a BinarySequence.
     * @param s - String to be encoded.
     * @return Encoded BinarySequence.
     */
    public BinarySequence encode(String s) {
        BinarySequence fullSeq = new BinarySequence();
        for (int i = 0; i < s.length(); i++) {
            fullSeq.append(getSequence(s.charAt(i)));
        }
        return fullSeq;
    }

    /**
     * @return length of the codeBook.
     */
    public int getLength() {
        return codeBook.getLength();
    }

    /**
     * Returns char at index position i.
     * @param i index position.
     * @return Character object at index position i.
     */
    public Character getChar(int i) {
        return codeBook.getKey(i);
    }
}
