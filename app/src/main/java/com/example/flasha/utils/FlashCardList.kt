data class FlashcardDT(
    val german: String,
    val english: String,
    val level: String,
    val category: String,
)

val flashcardList = listOf<FlashcardDT>(
  // A1 – Noun
  FlashcardDT("der Hund",  "the dog",  "A1",  "Noun" ),
  FlashcardDT( "das Haus",  "the house",  "A1",  "Noun" ),
  FlashcardDT( "die Katze",  "the cat",  "A1",  "Noun" ),
  FlashcardDT( "der Tisch",  "the table",  "A1",  "Noun" ),
  FlashcardDT( "das Wasser",  "the water",  "A1",  "Noun" ),

  // A1 – Verb
  FlashcardDT( "gehen",  "to go",  "A1",  "Verb" ),
  FlashcardDT( "essen",  "to eat",  "A1",  "Verb" ),
  FlashcardDT( "trinken",  "to drink",  "A1",  "Verb" ),
  FlashcardDT( "schlafen",  "to sleep",  "A1",  "Verb" ),
  FlashcardDT( "lesen",  "to read",  "A1",  "Verb" ),

  // A1 – Adjective
  FlashcardDT( "groß",  "big",  "A1",  "Adjective" ),
  FlashcardDT( "klein",  "small",  "A1",  "Adjective" ),
  FlashcardDT( "schön",  "beautiful",  "A1",  "Adjective" ),
  FlashcardDT( "gut",  "good",  "A1",  "Adjective" ),
  FlashcardDT( "neu",  "new",  "A1",  "Adjective" ),

  // A1 – Phrase
  FlashcardDT( "Guten Tag",  "Good day",  "A1",  "Phrase" ),
  FlashcardDT( "Wie geht es dir?",  "How are you?",  "A1",  "Phrase" ),
  FlashcardDT( "Danke schön",  "Thank you very much",  "A1",  "Phrase" ),
  FlashcardDT( "Auf Wiedersehen",  "Goodbye",  "A1",  "Phrase" ),
  FlashcardDT( "Guten Morgen",  "Good morning",  "A1",  "Phrase" ),

  // A2 – Noun
  FlashcardDT( "die Arbeit",  "the work",  "A2",  "Noun" ),
  FlashcardDT( "der Freund",  "the friend",  "A2",  "Noun" ),
  FlashcardDT( "die Schule",  "the school",  "A2",  "Noun" ),
  FlashcardDT( "das Auto",  "the car",  "A2",  "Noun" ),
  FlashcardDT( "die Familie",  "the family",  "A2",  "Noun" ),

  // A2 – Verb
  FlashcardDT( "arbeiten",  "to work",  "A2",  "Verb" ),
  FlashcardDT( "lernen",  "to learn",  "A2",  "Verb" ),
  FlashcardDT( "sprechen",  "to speak",  "A2",  "Verb" ),
  FlashcardDT( "verstehen",  "to understand",  "A2",  "Verb" ),
  FlashcardDT( "helfen",  "to help",  "A2",  "Verb" ),

  // A2 – Adjective
  FlashcardDT( "interessant",  "interesting",  "A2",  "Adjective" ),
  FlashcardDT( "schwierig",  "difficult",  "A2",  "Adjective" ),
  FlashcardDT( "einfach",  "easy/simple",  "A2",  "Adjective" ),
  FlashcardDT( "wichtig",  "important",  "A2",  "Adjective" ),
  FlashcardDT( "schnell",  "fast",  "A2",  "Adjective" ),

  // A2 – Phrase
  FlashcardDT( "Es tut mir leid",  "I am sorry",  "A2",  "Phrase" ),
  FlashcardDT( "Ich verstehe nicht",  "I don\'t understand",  "A2",  "Phrase" ),
  FlashcardDT( "Können Sie mir helfen?",  "Can you help me?",  "A2",  "Phrase" ),
  FlashcardDT( "Wie viel kostet das?",  "How much does it cost?",  "A2",  "Phrase" ),
  FlashcardDT( "Wo ist die Toilette?",  "Where is the bathroom?",  "A2",  "Phrase" ),

  // B1 – Noun
  FlashcardDT( "die Erfahrung",  "the experience",  "B1",  "Noun" ),
  FlashcardDT( "die Meinung",  "the opinion",  "B1",  "Noun" ),
  FlashcardDT( "der Unterschied",  "the difference",  "B1",  "Noun" ),
  FlashcardDT( "die Entscheidung",  "the decision",  "B1",  "Noun" ),
  FlashcardDT( "das Ergebnis",  "the result",  "B1",  "Noun" ),

  // B1 – Verb
  FlashcardDT( "diskutieren",  "to discuss",  "B1",  "Verb" ),
  FlashcardDT( "entscheiden",  "to decide",  "B1",  "Verb" ),
  FlashcardDT( "erklären",  "to explain",  "B1",  "Verb" ),
  FlashcardDT( "vergleichen",  "to compare",  "B1",  "Verb" ),
  FlashcardDT( "erreichen",  "to reach/achieve",  "B1",  "Verb" ),

  // B1 – Adjective
  FlashcardDT( "kompliziert",  "complicated",  "B1",  "Adjective" ),
  FlashcardDT( "notwendig",  "necessary",  "B1",  "Adjective" ),
  FlashcardDT( "möglich",  "possible",  "B1",  "Adjective" ),
  FlashcardDT( "ähnlich",  "similar",  "B1",  "Adjective" ),
  FlashcardDT( "verschieden",  "different",  "B1",  "Adjective" ),

  // B1 – Phrase
  FlashcardDT( "Was meinst du dazu?",  "What do you think about it?",  "B1",  "Phrase" ),
  FlashcardDT( "Meiner Meinung nach",  "In my opinion",  "B1",  "Phrase" ),
  FlashcardDT( "Es kommt darauf an",  "It depends",  "B1",  "Phrase" ),
  FlashcardDT( "Das macht Sinn",  "That makes sense",  "B1",  "Phrase" ),
  FlashcardDT( "Im Gegensatz zu",  "In contrast to",  "B1",  "Phrase" ),

  // B2 – Noun
  FlashcardDT( "die Herausforderung",  "the challenge",  "B2",  "Noun" ),
  FlashcardDT( "die Voraussetzung",  "the prerequisite",  "B2",  "Noun" ),
  FlashcardDT( "der Zusammenhang",  "the connection/context",  "B2",  "Noun" ),
  FlashcardDT( "die Auswirkung",  "the impact/effect",  "B2",  "Noun" ),
  FlashcardDT( "die Entwicklung",  "the development",  "B2",  "Noun" ),

  // B2 – Verb
  FlashcardDT( "berücksichtigen",  "to consider/take into account",  "B2",  "Verb" ),
  FlashcardDT( "beurteilen",  "to judge/assess",  "B2",  "Verb" ),
  FlashcardDT( "bewältigen",  "to cope with/manage",  "B2",  "Verb" ),
  FlashcardDT( "voraussetzen",  "to presuppose/assume",  "B2",  "Verb" ),
  FlashcardDT( "widerspiegeln",  "to reflect",  "B2",  "Verb" ),

  // B2 – Adjective
  FlashcardDT( "ausschlaggebend",  "decisive/crucial",  "B2",  "Adjective" ),
  FlashcardDT( "bedeutsam",  "significant",  "B2",  "Adjective" ),
  FlashcardDT( "umfassend",  "comprehensive",  "B2",  "Adjective" ),
  FlashcardDT( "wesentlich",  "essential",  "B2",  "Adjective" ),
  FlashcardDT( "anspruchsvoll",  "demanding/challenging",  "B2",  "Adjective" ),

  // B2 – Phrase
  FlashcardDT( "Daraus lässt sich schließen",  "From this one can conclude",  "B2",  "Phrase" ),
  FlashcardDT( "Es ist anzunehmen, dass",  "It is to be assumed that",  "B2",  "Phrase" ),
  FlashcardDT( "Im Großen und Ganzen",  "By and large/On the whole",  "B2",  "Phrase" ),
  FlashcardDT( "Unter Berücksichtigung von",  "Taking into consideration",  "B2",  "Phrase" ),
  FlashcardDT( "Das hängt damit zusammen",  "That is connected with",  "B2",  "Phrase" ),
);
