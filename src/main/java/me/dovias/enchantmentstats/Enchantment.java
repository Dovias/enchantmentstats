package me.dovias.enchantmentstats;

public record Enchantment(String identifier, int weight, int minLevel, int maxLevel, Cost minCost, Cost maxCost) implements Identifiable<String> {

    public record Cost(int base, int level) {
        public int forLevel(int level) {
            return this.base + this.level * (level - 1);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder implements me.dovias.enchantmentstats.Builder<Cost> {
            private int base;
            private int level;

            public Builder base(int base) {
                this.base = base;
                return this;
            }

            public Builder level(int level) {
                this.level = level;
                return this;
            }

            public Cost build() {
                return new Cost(base, level);
            }
        }
    }

    public static Enchantment.Builder builder() {
        return new Enchantment.Builder();
    }

    public static class Builder implements me.dovias.enchantmentstats.Builder<Enchantment> {
        private String identifier;
        private int weight;
        private int minLevel;
        private int maxLevel;
        private Cost minCost;
        private Cost maxCost;

        private Builder() {}


        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder minLevel(int minLevel) {
            this.minLevel = minLevel;
            return this;
        }

        public Builder maxLevel(int maxLevel) {
            this.maxLevel = maxLevel;
            return this;
        }

        public Builder minCost(Cost minCost) {
            this.minCost = minCost;
            return this;
        }

        public Builder minCost(Cost.Builder builder) {
            this.minCost = builder.build();
            return this;
        }

        public Builder maxCost(Cost maxCost) {
            this.maxCost = maxCost;
            return this;
        }

        public Builder maxCost(Cost.Builder builder) {
            this.maxCost = builder.build();
            return this;
        }

        public Enchantment build() {
            return new Enchantment(identifier, weight, minLevel, maxLevel, minCost, maxCost);
        }
    }
}
