package me.dovias.enchantmentstats.enchantment;

public class SimpleEnchantment implements Enchantment {
    private final Type type;
    private final int level;

    public SimpleEnchantment(Type type, int level) {
        this.type = type;
        this.level = level;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}
