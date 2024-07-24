package me.dovias.enchantmentstats;

public record ItemType(String identifier, int enchantability) implements Identifiable<String> {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder implements me.dovias.enchantmentstats.Builder<ItemType> {
        private String identifier;
        private int enchantability;

        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder enchantability(int enchantability) {
            this.enchantability = enchantability;
            return this;
        }

        @Override
        public ItemType build() {
            return new ItemType(this.identifier, this.enchantability);
        }
    }

}
