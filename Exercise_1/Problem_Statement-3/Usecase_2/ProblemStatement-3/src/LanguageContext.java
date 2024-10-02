class LanguageContext {
    private LocalizationStrategy strategy;

    public void setLocalizationStrategy(LocalizationStrategy strategy) {
        this.strategy = strategy;
    }

    public String greetUser() {
        if (strategy == null) {
            throw new IllegalStateException("Localization strategy not set");
        }
        return strategy.getGreeting();
    }
}