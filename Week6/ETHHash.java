package Week6;

class ETHHash extends HashTable {
    public ETHHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if(item == null) return 0;
        int n = item.length();
        return b(item, n - 1) % super.getCapacity();
    }

    private int b(String item, int index) {
        if(index == -1) return 1;
        int c = (int) item.charAt(index);
        int calc = b(item, index - 1) % 257 + 1;
        return c * calc;
    }
}

class GNUCPPHash extends HashTable {
    public GNUCPPHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if(item == null) return 0;
        int n = item.length();
        return (b(item, n - 1) & ((1 << 31) - 1)) % super.getCapacity();
    }

    private int b(String item, int index) {
        if(index == -1) return 0;
        return 4 * b(item, index - 1) + ((int) item.charAt(index));
    }
}

class GNUCC1Hash extends HashTable {
    public GNUCC1Hash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if(item == null) return 0;
        return (b(item, item.length() - 1) & ((1 << 30) - 1)) % super.getCapacity();
    }

    private int b(String item, int index) {
        if(index == -1) return item.length();
        return 613 * b(item, index - 1) + ((int) item.charAt(index));
    }
}

class HashCodeHash extends HashTable {
    public HashCodeHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if(item == null) return 0;
        return Math.abs(item.hashCode()) % super.getCapacity();
    }
}


