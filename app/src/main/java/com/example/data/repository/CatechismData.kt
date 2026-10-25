package com.example.data.repository

import com.example.data.models.CatechismChapter
import com.example.data.models.CatechismNumberedArticle
import com.example.data.models.CatechismPart
import com.example.data.models.CatechismSection
import com.example.data.models.LocalizedText

object CatechismData {

    val catechismParts: List<CatechismPart> = listOf(
        // PART 1: The Profession of Faith
        CatechismPart(
            partNumber = 1,
            title = LocalizedText("Primera Parte: La Profesión de la Fe", "Part One: The Profession of Faith", "Primeira Parte: A Profissão da Fé"),
            subtitle = LocalizedText("El Credo y la Revelación Divina", "The Creed & Divine Revelation", "O Credo e a Revelação Divina"),
            cccRange = "§§ 1 - 1065",
            description = LocalizedText(
                "Trata sobre el misterio de Dios, la capacidad del hombre para conocer al Creador, la Revelación que culmina en Cristo, y los doce artículos del Credo apostólico.",
                "Explores God's revelation, the human capacity for God, and the 12 articles of the Apostles' Creed.",
                "Aborda a Revelação de Deus, a vocação do homem e os doze artigos da fé católica."
            ),
            sections = listOf(
                CatechismSection(
                    partNumber = 1,
                    sectionNumber = 1,
                    title = LocalizedText("Sección 1: 'Creo' — 'Creemos'", "Section 1: 'I Believe' — 'We Believe'", "Seção 1: 'Creio' — 'Cremos'"),
                    chapters = listOf(
                        CatechismChapter(
                            chapterNumber = 1,
                            title = LocalizedText("El Hombre es 'capaz' de Dios", "Man's Capacity for God", "O Homem é 'Capaz' de Deus"),
                            articleRangeDisplay = "§§ 26 - 49",
                            articles = listOf(
                                CatechismNumberedArticle(
                                    cccNumber = 27,
                                    title = LocalizedText("El deseo de Dios en el corazón humano", "The Desire for God", "O Desejo de Deus no Homem"),
                                    content = LocalizedText(
                                        "El deseo de Dios está inscrito en el corazón del hombre, porque el hombre ha sido creado por Dios y para Dios; y Dios no cesa de atraer al hombre hacia sí, y sólo en Dios encontrará el hombre la verdad y la dicha que no cesa de buscar.",
                                        "The desire for God is written in the human heart, because man is created by God and for God; and God never ceases to draw man to Himself. Only in God will he find the truth and happiness he never stops searching for.",
                                        "O desejo de Deus está inscrito no coração do homem, já que o homem foi criado por Deus e para Deus. Somente em Deus o homem encontrará a verdade e a felicidade que procura sem cessar."
                                    ),
                                    biblicalReferences = "Hch 17, 26-28; Sal 105, 3",
                                    inBriefSummary = LocalizedText(
                                        "El hombre es por naturaleza y por vocación un ser religioso. Hecho a imagen de Dios, su plenitud está en la comunión divina.",
                                        "Man is by nature and vocation a religious being, capable of knowing and loving his Creator.",
                                        "O homem é por natureza um ser religioso chamado à comunhão com Deus."
                                    )
                                ),
                                CatechismNumberedArticle(
                                    cccNumber = 31,
                                    title = LocalizedText("Las vías de acceso al conocimiento de Dios", "Ways of Knowing God", "Vias de Acesso ao Conhecimento de Deus"),
                                    content = LocalizedText(
                                        "Creado a imagen de Dios, llamado a conocerle y amarle, el hombre que busca a Dios descubre ciertas vías para acceder al conocimiento de Dios: el mundo material con su orden y belleza, y la persona humana con su voz de la conciencia moral.",
                                        "Created in God's image and called to know and love Him, the person who seeks God discovers certain ways of coming to know Him: through the physical universe and through the human soul with its sense of moral truth.",
                                        "Criado à imagem de Deus, o homem descobre vias para conhecer o Criador: o mundo com sua harmonia e o coração humano com sua sede de infinito."
                                    ),
                                    biblicalReferences = "Sab 13, 1-9; Rom 1, 19-20",
                                    inBriefSummary = LocalizedText(
                                        "Con su razón natural, el hombre puede conocer a Dios con certeza a partir de sus obras.",
                                        "With natural reason, man can know God with certainty through His created works.",
                                        "Pela razão natural, o homem pode chegar ao conhecimento certo de Deus."
                                    )
                                )
                            )
                        )
                    )
                ),
                CatechismSection(
                    partNumber = 1,
                    sectionNumber = 2,
                    title = LocalizedText("Sección 2: La Profesión de la Fe Cristiana (Los Símbolos de la Fe)", "Section 2: The Creed (Symbols of Faith)", "Seção 2: A Profissão da Fé Cristã"),
                    chapters = listOf(
                        CatechismChapter(
                            chapterNumber = 1,
                            title = LocalizedText("Creo en Dios Padre Todopoderoso", "I Believe in God the Father Almighty", "Creio em Deus Pai Todo-Poderoso"),
                            articleRangeDisplay = "§§ 198 - 421",
                            articles = listOf(
                                CatechismNumberedArticle(
                                    cccNumber = 199,
                                    title = LocalizedText("Creo en un solo Dios", "I Believe in One God", "Creio em um só Deus"),
                                    content = LocalizedText(
                                        "«Escucha, Israel: el Señor nuestro Dios es el único Señor» (Dt 6, 4). Dios confiesa que Él es el Único, no hay otro. El misterio central de la fe católica es la Santísima Trinidad: un solo Dios en Tres Personas divinas (Padre, Hijo y Espíritu Santo).",
                                        "“Hear, O Israel: The Lord our God is one Lord” (Deut 6:4). The central mystery of Christian faith and life is the mystery of the Most Holy Trinity.",
                                        "“Ouve, ó Israel: o Senhor nosso Deus é o único Senhor”. O mistério central da fé católica é a Santíssima Trindade."
                                    ),
                                    biblicalReferences = "Dt 6, 4; Mt 28, 19",
                                    inBriefSummary = LocalizedText("Dios es Amor (1 Jn 4, 8) y verdad eterna.", "God is Truth and Love.", "Deus é Verdade e Amor infinito.")
                                )
                            )
                        )
                    )
                )
            )
        ),

        // PART 2: The Celebration of the Christian Mystery (The Sacraments)
        CatechismPart(
            partNumber = 2,
            title = LocalizedText("Segunda Parte: La Celebración del Misterio Cristiano", "Part Two: The Celebration of the Christian Mystery", "Segunda Parte: A Celebração do Mistério Cristão"),
            subtitle = LocalizedText("La Liturgia y los Siete Sacramentos de la Iglesia", "The Liturgy & The Seven Sacraments", "A Liturgia e os Sete Sacramentos"),
            cccRange = "§§ 1066 - 1690",
            description = LocalizedText(
                "La economía sacramental por la que Cristo comunica los frutos del Misterio Pascual en la liturgia y en los 7 Sacramentos de salvación.",
                "How the fruits of Christ's Paschal mystery are communicated through the liturgy and the seven sacraments.",
                "A economia sacramental da Igreja através dos sete sacramentos instituídos por Cristo."
            ),
            sections = listOf(
                CatechismSection(
                    partNumber = 2,
                    sectionNumber = 2,
                    title = LocalizedText("Los Siete Sacramentos de la Iglesia", "The Seven Sacraments of the Church", "Os Sete Sacramentos da Igreja"),
                    chapters = listOf(
                        CatechismChapter(
                            chapterNumber = 3,
                            title = LocalizedText("El Santísimo Sacramento de la Eucaristía", "The Sacrament of the Eucharist", "O Santíssimo Sacramento da Eucaristia"),
                            articleRangeDisplay = "§§ 1322 - 1419",
                            articles = listOf(
                                CatechismNumberedArticle(
                                    cccNumber = 1324,
                                    title = LocalizedText("Fuente y Culmen de toda la vida cristiana", "Source and Summit of Christian Life", "Fonte e Ápice de Toda a Vida Cristã"),
                                    content = LocalizedText(
                                        "La Eucaristía es «fuente y culmen de toda la vida cristiana». Los demás sacramentos, al igual que todos los ministerios eclesiales y las obras de apostolado, están unidos a la Eucaristía y hacia ella se ordenan. Pues en la sagrada Eucaristía se contiene todo el bien espiritual de la Iglesia, a saber, Cristo mismo, nuestra Pascua.",
                                        "The Eucharist is the “source and summit of the Christian life.” The other sacraments, and indeed all ecclesiastical ministries and works of the apostolate, are bound up with the Eucharist and are oriented toward it. For in the blessed Eucharist is contained the whole spiritual good of the Church, namely Christ Himself, our Pasch.",
                                        "A Eucaristia é “fonte e ápice de toda a vida cristã”. Os demais sacramentos e todas as obras de apostolado estão unidos à Eucaristia e a ela se ordenam. Pois na Santíssima Eucaristia está contido todo o tesouro espiritual da Igreja: o próprio Cristo, nossa Páscoa."
                                    ),
                                    biblicalReferences = "Lumen Gentium 11; Jn 6, 51-58; 1 Cor 11, 23-26",
                                    inBriefSummary = LocalizedText(
                                        "En la Eucaristía recibimos la presencia real, sustancial y verdadera de Jesucristo en Cuerpo, Sangre, Alma y Divinidad mediante la Transustanciación.",
                                        "Through transubstantiation, the bread and wine become the real Body, Blood, Soul, and Divinity of our Lord Jesus Christ.",
                                        "Pela transubstanciação, o pão e o vinho tornam-se verdadeiramente o Corpo e Sangue de Cristo."
                                    )
                                ),
                                CatechismNumberedArticle(
                                    cccNumber = 1374,
                                    title = LocalizedText("La Presencia Real de Cristo en la Eucaristía", "The Real Presence of Christ", "A Presença Real de Cristo"),
                                    content = LocalizedText(
                                        "El modo de presencia de Cristo bajo las especies eucarísticas es singular. Eleva a la Eucaristía por encima de todos los sacramentos y hace de ella «como el culmen de la vida espiritual y el fin al que tienden todos los sacramentos». En el santísimo sacramento de la Eucaristía están «contenidos verdadera, real y sustancialmente el Cuerpo y la Sangre junto con el alma y la divinidad de nuestro Señor Jesucristo, y, por consiguiente, Cristo entero».",
                                        "The mode of Christ's presence under the Eucharistic species is unique. In the most blessed sacrament of the Eucharist the body and blood, together with the soul and divinity, of our Lord Jesus Christ and, therefore, the whole Christ is truly, really, and substantially contained.",
                                        "No santíssimo sacramento da Eucaristia estão contidos verdadeira, real e substancialmente o Corpo e o Sangue juntamente com a alma e a divindade de nosso Senhor Jesus Cristo."
                                    ),
                                    biblicalReferences = "Concilio de Trento (DS 1651); Mt 26, 26-28",
                                    inBriefSummary = LocalizedText(
                                        "La presencia eucarística de Cristo comienza en el momento de la consagración y dura todo el tiempo que subsistan las especies eucarísticas.",
                                        "Christ's Eucharistic presence begins at the moment of consecration and endures as long as the Eucharistic species subsist.",
                                        "A presença de Cristo perdura enquanto subsistirem as espécies consagradas."
                                    )
                                )
                            )
                        )
                    )
                )
            )
        ),

        // PART 3: Life in Christ (Morality & Commandments)
        CatechismPart(
            partNumber = 3,
            title = LocalizedText("Tercera Parte: La Vida en Cristo", "Part Three: Life in Christ", "Terceira Parte: A Vida em Cristo"),
            subtitle = LocalizedText("La Dignidad de la Persona y los Diez Mandamientos", "The Human Vocation & The Commandments", "A Dignidade da Pessoa e os Mandamentos"),
            cccRange = "§§ 1691 - 2557",
            description = LocalizedText(
                "La moral cristiana, las bienaventuranzas, la libertad y la gracia, los pecados y las virtudes, y el examen detallado de los Diez Mandamientos.",
                "Christian moral action, the Beatitudes, grace and justification, and the full explanation of the Decalogue.",
                "A vocação moral do cristão, a vida da graça, os Dez Mandamentos e o seguimento de Jesus."
            ),
            sections = listOf(
                CatechismSection(
                    partNumber = 3,
                    sectionNumber = 1,
                    title = LocalizedText("La Vocación del Hombre: La Vida en el Espíritu", "Man's Vocation: Life in the Spirit", "A Vocação do Homem: A Vida no Espírito"),
                    chapters = listOf(
                        CatechismChapter(
                            chapterNumber = 1,
                            title = LocalizedText("La Dignidad de la Persona Humana", "The Dignity of the Human Person", "A Dignidade da Pessoa Humana"),
                            articleRangeDisplay = "§§ 1700 - 1876",
                            articles = listOf(
                                CatechismNumberedArticle(
                                    cccNumber = 1857,
                                    title = LocalizedText("Las condiciones del Pecado Mortal", "Conditions for Mortal Sin", "As Três Condições do Pecado Mortal"),
                                    content = LocalizedText(
                                        "Para que un pecado sea mortal se requieren tres condiciones simultáneas: «Es pecado mortal lo que tiene por objeto una materia grave y que, además, es cometido con pleno conocimiento y deliberado consentimiento».",
                                        "For a sin to be mortal, three conditions must together be met: “Mortal sin is sin whose object is grave matter and which is also committed with full knowledge and deliberate consent.”",
                                        "Para que um pecado seja mortal, requerem-se três condições simultâneas: matéria grave, pleno conhecimento do caráter culpável e pleno consentimento deliberado."
                                    ),
                                    biblicalReferences = "Mc 10, 19; 1 Jn 5, 16-17; Concilio de Trento",
                                    inBriefSummary = LocalizedText(
                                        "El pecado mortal destruye la caridad en el corazón del hombre; entraña la pérdida de la gracia santificante y requiere el Sacramento de la Penitencia.",
                                        "Mortal sin destroys charity in the human heart and results in the loss of sanctifying grace without confession.",
                                        "O pecado mortal exige a reconciliação com Deus através do sacramento da Confissão."
                                    )
                                )
                            )
                        )
                    )
                )
            )
        ),

        // PART 4: Christian Prayer
        CatechismPart(
            partNumber = 4,
            title = LocalizedText("Cuarta Parte: La Oración Cristiana", "Part Four: Christian Prayer", "Quarta Parte: A Oração Cristã"),
            subtitle = LocalizedText("La Vida de Oración y el Padre Nuestro", "Prayer in the Christian Life & The Our Father", "A Vida de Oração e o Pai-Nosso"),
            cccRange = "§§ 2558 - 2865",
            description = LocalizedText(
                "La naturaleza de la oración según los grandes santos y el análisis místico y teológico de las siete peticiones del Padre Nuestro.",
                "The revelation of prayer, contemplative meditation, and the Seven Petitions of the Lord's Prayer.",
                "A contemplação, a oração interior e a explicação teológica da oração do Pai-Nosso."
            ),
            sections = listOf(
                CatechismSection(
                    partNumber = 4,
                    sectionNumber = 1,
                    title = LocalizedText("La Oración en la Vida Cristiana", "Prayer in Christian Life", "A Oração na Vida Cristã"),
                    chapters = listOf(
                        CatechismChapter(
                            chapterNumber = 1,
                            title = LocalizedText("La Revelación de la Oración", "The Revelation of Prayer", "A Revelação da Oração"),
                            articleRangeDisplay = "§§ 2558 - 2649",
                            articles = listOf(
                                CatechismNumberedArticle(
                                    cccNumber = 2559,
                                    title = LocalizedText("La oración como elevación del alma a Dios", "Prayer as Raising the Mind and Heart", "A Oração como Elevação da Alma a Deus"),
                                    content = LocalizedText(
                                        "«La oración es la elevación del alma a Dios o la petición a Dios de bienes convenientes» (San Juan Damasceno). ¿Desde dónde hablamos cuando oramos? ¿Desde la altura de nuestro orgullo o «desde lo más profundo» (Sal 130, 1) de un corazón humilde y contrito? La humildad es la base de la oración.",
                                        "“Prayer is the raising of one's mind and heart to God or the requesting of good things from God” (St. John Damascene). But when we pray, do we speak from our pride, or out of the depths of a humble and contrite heart? Humility is the foundation of prayer.",
                                        "“A oração é a elevação da alma a Deus ou o pedido a Deus de bens convenientes” (São João Damasceno). A humildade é a base da oração."
                                    ),
                                    biblicalReferences = "Sal 130, 1; Lc 18, 9-14",
                                    inBriefSummary = LocalizedText(
                                        "La oración cristiana es una relación de alianza entre Dios y el hombre en Cristo.",
                                        "Christian prayer is a covenant relationship between God and man in Christ.",
                                        "A oração cristã é o diálogo vivo de amor filial entre o Pai e Seus filhos."
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    )

    fun findArticleByNumber(num: Int): CatechismNumberedArticle? {
        for (part in catechismParts) {
            for (sec in part.sections) {
                for (ch in sec.chapters) {
                    for (art in ch.articles) {
                        if (art.cccNumber == num) return art
                    }
                }
            }
        }
        return null
    }
}
