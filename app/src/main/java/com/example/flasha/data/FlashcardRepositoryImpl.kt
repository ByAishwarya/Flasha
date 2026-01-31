package com.example.flasha.data

import com.example.flasha.interfaces.FlashcardRepository

/**
 * Concrete implementation of the FlashcardRepository interface.
 * This implementation uses a simple in-memory list as the data source.
 */
class FlashcardRepositoryImpl : FlashcardRepository {

    // In-memory database of flashcards
    private val allFlashcards = listOf(
        // ==================== A1 LEVEL ====================

        // A1 - Verbs (10)
        FlashcardDT("gehen", "to go", "A1", "Verbs"),
        FlashcardDT("haben", "to have", "A1", "Verbs"),
        FlashcardDT("sein", "to be", "A1", "Verbs"),
        FlashcardDT("machen", "to make/do", "A1", "Verbs"),
        FlashcardDT("kommen", "to come", "A1", "Verbs"),
        FlashcardDT("sehen", "to see", "A1", "Verbs"),
        FlashcardDT("essen", "to eat", "A1", "Verbs"),
        FlashcardDT("trinken", "to drink", "A1", "Verbs"),
        FlashcardDT("schlafen", "to sleep", "A1", "Verbs"),
        FlashcardDT("spielen", "to play", "A1", "Verbs"),

        // A1 - Nouns (10)
        FlashcardDT("der Tisch", "the table", "A1", "Nouns"),
        FlashcardDT("das Buch", "the book", "A1", "Nouns"),
        FlashcardDT("die Frau", "the woman", "A1", "Nouns"),
        FlashcardDT("der Mann", "the man", "A1", "Nouns"),
        FlashcardDT("das Haus", "the house", "A1", "Nouns"),
        FlashcardDT("das Kind", "the child", "A1", "Nouns"),
        FlashcardDT("der Hund", "the dog", "A1", "Nouns"),
        FlashcardDT("die Katze", "the cat", "A1", "Nouns"),
        FlashcardDT("das Wasser", "the water", "A1", "Nouns"),
        FlashcardDT("das Brot", "the bread", "A1", "Nouns"),

        // A1 - Adjectives (10)
        FlashcardDT("groß", "big/tall", "A1", "Adjectives"),
        FlashcardDT("klein", "small", "A1", "Adjectives"),
        FlashcardDT("gut", "good", "A1", "Adjectives"),
        FlashcardDT("schlecht", "bad", "A1", "Adjectives"),
        FlashcardDT("neu", "new", "A1", "Adjectives"),
        FlashcardDT("alt", "old", "A1", "Adjectives"),
        FlashcardDT("schön", "beautiful", "A1", "Adjectives"),
        FlashcardDT("heiß", "hot", "A1", "Adjectives"),
        FlashcardDT("kalt", "cold", "A1", "Adjectives"),
        FlashcardDT("jung", "young", "A1", "Adjectives"),

        // A1 - Phrases (10)
        FlashcardDT("Guten Tag", "Good day", "A1", "Phrases"),
        FlashcardDT("Wie geht's?", "How are you?", "A1", "Phrases"),
        FlashcardDT("Danke schön", "Thank you", "A1", "Phrases"),
        FlashcardDT("Bitte schön", "You're welcome", "A1", "Phrases"),
        FlashcardDT("Auf Wiedersehen", "Goodbye", "A1", "Phrases"),
        FlashcardDT("Guten Morgen", "Good morning", "A1", "Phrases"),
        FlashcardDT("Gute Nacht", "Good night", "A1", "Phrases"),
        FlashcardDT("Ich heiße...", "My name is...", "A1", "Phrases"),
        FlashcardDT("Wie heißen Sie?", "What is your name?", "A1", "Phrases"),
        FlashcardDT("Entschuldigung", "Excuse me", "A1", "Phrases"),

        // ==================== A2 LEVEL ====================

        // A2 - Verbs (10)
        FlashcardDT("lesen", "to read", "A2", "Verbs"),
        FlashcardDT("schreiben", "to write", "A2", "Verbs"),
        FlashcardDT("verstehen", "to understand", "A2", "Verbs"),
        FlashcardDT("sprechen", "to speak", "A2", "Verbs"),
        FlashcardDT("lernen", "to learn", "A2", "Verbs"),
        FlashcardDT("arbeiten", "to work", "A2", "Verbs"),
        FlashcardDT("kaufen", "to buy", "A2", "Verbs"),
        FlashcardDT("verkaufen", "to sell", "A2", "Verbs"),
        FlashcardDT("warten", "to wait", "A2", "Verbs"),
        FlashcardDT("helfen", "to help", "A2", "Verbs"),

        // A2 - Nouns (10)
        FlashcardDT("die Schule", "the school", "A2", "Nouns"),
        FlashcardDT("der Lehrer", "the teacher", "A2", "Nouns"),
        FlashcardDT("das Wetter", "the weather", "A2", "Nouns"),
        FlashcardDT("die Arbeit", "the work", "A2", "Nouns"),
        FlashcardDT("der Freund", "the friend (male)", "A2", "Nouns"),
        FlashcardDT("die Freundin", "the friend (female)", "A2", "Nouns"),
        FlashcardDT("das Geld", "the money", "A2", "Nouns"),
        FlashcardDT("die Zeit", "the time", "A2", "Nouns"),
        FlashcardDT("der Bahnhof", "the train station", "A2", "Nouns"),
        FlashcardDT("das Krankenhaus", "the hospital", "A2", "Nouns"),

        // A2 - Adjectives (10)
        FlashcardDT("schnell", "fast", "A2", "Adjectives"),
        FlashcardDT("langsam", "slow", "A2", "Adjectives"),
        FlashcardDT("wichtig", "important", "A2", "Adjectives"),
        FlashcardDT("richtig", "correct", "A2", "Adjectives"),
        FlashcardDT("falsch", "wrong", "A2", "Adjectives"),
        FlashcardDT("teuer", "expensive", "A2", "Adjectives"),
        FlashcardDT("billig", "cheap", "A2", "Adjectives"),
        FlashcardDT("lecker", "delicious", "A2", "Adjectives"),
        FlashcardDT("müde", "tired", "A2", "Adjectives"),
        FlashcardDT("glücklich", "happy", "A2", "Adjectives"),

        // A2 - Phrases (10)
        FlashcardDT("Es tut mir leid", "I'm sorry", "A2", "Phrases"),
        FlashcardDT("Ich verstehe nicht", "I don't understand", "A2", "Phrases"),
        FlashcardDT("Können Sie mir helfen?", "Can you help me?", "A2", "Phrases"),
        FlashcardDT("Wie viel kostet das?", "How much does this cost?", "A2", "Phrases"),
        FlashcardDT("Wo ist die Toilette?", "Where is the toilet?", "A2", "Phrases"),
        FlashcardDT("Ich hätte gern...", "I would like...", "A2", "Phrases"),
        FlashcardDT("Was bedeutet das?", "What does that mean?", "A2", "Phrases"),
        FlashcardDT("Sprechen Sie Englisch?", "Do you speak English?", "A2", "Phrases"),
        FlashcardDT("Ich bin verloren", "I am lost", "A2", "Phrases"),
        FlashcardDT("Bis später", "See you later", "A2", "Phrases"),

        // ==================== B1 LEVEL ====================

        // B1 - Verbs (10)
        FlashcardDT("entwickeln", "to develop", "B1", "Verbs"),
        FlashcardDT("erklären", "to explain", "B1", "Verbs"),
        FlashcardDT("entscheiden", "to decide", "B1", "Verbs"),
        FlashcardDT("verbessern", "to improve", "B1", "Verbs"),
        FlashcardDT("vergleichen", "to compare", "B1", "Verbs"),
        FlashcardDT("vorschlagen", "to suggest", "B1", "Verbs"),
        FlashcardDT("beschreiben", "to describe", "B1", "Verbs"),
        FlashcardDT("erinnern", "to remember", "B1", "Verbs"),
        FlashcardDT("bemerken", "to notice", "B1", "Verbs"),
        FlashcardDT("erreichen", "to reach/achieve", "B1", "Verbs"),

        // B1 - Nouns (10)
        FlashcardDT("die Prüfung", "the exam", "B1", "Nouns"),
        FlashcardDT("die Erfahrung", "the experience", "B1", "Nouns"),
        FlashcardDT("die Meinung", "the opinion", "B1", "Nouns"),
        FlashcardDT("die Bedeutung", "the meaning", "B1", "Nouns"),
        FlashcardDT("der Unterschied", "the difference", "B1", "Nouns"),
        FlashcardDT("die Möglichkeit", "the possibility", "B1", "Nouns"),
        FlashcardDT("die Beziehung", "the relationship", "B1", "Nouns"),
        FlashcardDT("der Vorteil", "the advantage", "B1", "Nouns"),
        FlashcardDT("der Nachteil", "the disadvantage", "B1", "Nouns"),
        FlashcardDT("die Lösung", "the solution", "B1", "Nouns"),

        // B1 - Adjectives (10)
        FlashcardDT("möglich", "possible", "B1", "Adjectives"),
        FlashcardDT("notwendig", "necessary", "B1", "Adjectives"),
        FlashcardDT("wahrscheinlich", "probable", "B1", "Adjectives"),
        FlashcardDT("ähnlich", "similar", "B1", "Adjectives"),
        FlashcardDT("verschieden", "different", "B1", "Adjectives"),
        FlashcardDT("zufrieden", "satisfied", "B1", "Adjectives"),
        FlashcardDT("verantwortlich", "responsible", "B1", "Adjectives"),
        FlashcardDT("unabhängig", "independent", "B1", "Adjectives"),
        FlashcardDT("erfolgreich", "successful", "B1", "Adjectives"),
        FlashcardDT("zuverlässig", "reliable", "B1", "Adjectives"),

        // B1 - Phrases (10)
        FlashcardDT("Meiner Meinung nach", "In my opinion", "B1", "Phrases"),
        FlashcardDT("Es kommt darauf an", "It depends", "B1", "Phrases"),
        FlashcardDT("Ich bin der Meinung, dass...", "I am of the opinion that...", "B1", "Phrases"),
        FlashcardDT("Was halten Sie davon?", "What do you think about it?", "B1", "Phrases"),
        FlashcardDT("Es handelt sich um...", "It is about...", "B1", "Phrases"),
        FlashcardDT("Im Vergleich zu...", "In comparison to...", "B1", "Phrases"),
        FlashcardDT("Soweit ich weiß", "As far as I know", "B1", "Phrases"),
        FlashcardDT("Es lohnt sich", "It's worth it", "B1", "Phrases"),
        FlashcardDT("Ich freue mich auf...", "I'm looking forward to...", "B1", "Phrases"),
        FlashcardDT("Es macht nichts", "It doesn't matter", "B1", "Phrases"),

        // ==================== B2 LEVEL ====================

        // B2 - Verbs (10)
        FlashcardDT("beeinflussen", "to influence", "B2", "Verbs"),
        FlashcardDT("berücksichtigen", "to consider/take into account", "B2", "Verbs"),
        FlashcardDT("überzeugen", "to convince", "B2", "Verbs"),
        FlashcardDT("behaupten", "to claim/assert", "B2", "Verbs"),
        FlashcardDT("widersprechen", "to contradict", "B2", "Verbs"),
        FlashcardDT("zusammenfassen", "to summarize", "B2", "Verbs"),
        FlashcardDT("voraussetzen", "to presuppose", "B2", "Verbs"),
        FlashcardDT("bewältigen", "to cope with/manage", "B2", "Verbs"),
        FlashcardDT("auseinandersetzen", "to deal with/examine", "B2", "Verbs"),
        FlashcardDT("hervorheben", "to emphasize", "B2", "Verbs"),

        // B2 - Nouns (10)
        FlashcardDT("die Regierung", "the government", "B2", "Nouns"),
        FlashcardDT("die Gesellschaft", "the society", "B2", "Nouns"),
        FlashcardDT("die Wirtschaft", "the economy", "B2", "Nouns"),
        FlashcardDT("die Umwelt", "the environment", "B2", "Nouns"),
        FlashcardDT("der Einfluss", "the influence", "B2", "Nouns"),
        FlashcardDT("die Voraussetzung", "the prerequisite", "B2", "Nouns"),
        FlashcardDT("der Zusammenhang", "the context/connection", "B2", "Nouns"),
        FlashcardDT("die Auseinandersetzung", "the dispute/discussion", "B2", "Nouns"),
        FlashcardDT("der Standpunkt", "the viewpoint", "B2", "Nouns"),
        FlashcardDT("die Entwicklung", "the development", "B2", "Nouns"),

        // B2 - Adjectives (10)
        FlashcardDT("wesentlich", "essential", "B2", "Adjectives"),
        FlashcardDT("erheblich", "considerable", "B2", "Adjectives"),
        FlashcardDT("offensichtlich", "obvious", "B2", "Adjectives"),
        FlashcardDT("umstritten", "controversial", "B2", "Adjectives"),
        FlashcardDT("angemessen", "appropriate", "B2", "Adjectives"),
        FlashcardDT("bemerkenswert", "remarkable", "B2", "Adjectives"),
        FlashcardDT("ausschlaggebend", "decisive", "B2", "Adjectives"),
        FlashcardDT("unerlässlich", "indispensable", "B2", "Adjectives"),
        FlashcardDT("fragwürdig", "questionable", "B2", "Adjectives"),
        FlashcardDT("nachhaltig", "sustainable", "B2", "Adjectives"),

        // B2 - Phrases (10)
        FlashcardDT("Im Großen und Ganzen", "By and large", "B2", "Phrases"),
        FlashcardDT("Es liegt auf der Hand", "It's obvious", "B2", "Phrases"),
        FlashcardDT("Unter Berücksichtigung", "Taking into consideration", "B2", "Phrases"),
        FlashcardDT("Es steht außer Frage", "It's beyond question", "B2", "Phrases"),
        FlashcardDT("Im Hinblick auf", "With regard to", "B2", "Phrases"),
        FlashcardDT("Es sei denn", "Unless", "B2", "Phrases"),
        FlashcardDT("Darüber hinaus", "Furthermore", "B2", "Phrases"),
        FlashcardDT("Nichtsdestotrotz", "Nevertheless", "B2", "Phrases"),
        FlashcardDT("Angesichts der Tatsache", "In view of the fact", "B2", "Phrases"),
        FlashcardDT("Letzten Endes", "Ultimately", "B2", "Phrases")
    )

    override fun getLevels(): List<String> {
        return allFlashcards.map { it.level }.distinct().sorted()
    }

    override fun getCategoriesForLevel(level: String): List<String> {
        return allFlashcards.filter { it.level == level }.map { it.category }.distinct().sorted()
    }

    override fun getFlashcards(level: String, category: String): List<FlashcardDT> {
        return allFlashcards.filter { it.level == level && it.category == category }
    }
}