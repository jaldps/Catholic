package com.example.data.repository

import com.example.data.models.LocalizedText
import com.example.data.models.Novena
import com.example.data.models.NovenaDay

object CompleteNovenasData {

    val sacredHeartNovena = Novena(
        id = "sacred_heart",
        title = LocalizedText("Novena Oficial al Sagrado Corazón de Jesús", "Official Novena to the Sacred Heart of Jesus", "Novena Oficial ao Sagrado Coração de Jesus"),
        patron = LocalizedText("El Amor Divino y la Reparación", "Divine Love & Reparation", "O Amor Divino e a Reparação"),
        category = LocalizedText("Amor Divino y Gracia", "Divine Love & Grace", "Amor Divino e Graça"),
        description = LocalizedText(
            "Novena completa de 9 días basada en las revelaciones de Nuestro Señor Jesucristo a Santa Margarita María de Alacoque en Paray-le-Monial y aprobada por la Santa Sede.",
            "Complete 9-day Novena revealed by Jesus Christ to Saint Margaret Mary Alacoque in Paray-le-Monial and authorized by the Vatican.",
            "Novena completa de 9 dias revelada por Jesus a Santa Margarida Maria Alacoque com todas as orações autênticas."
        ),
        miraculousHistory = LocalizedText(
            "Jesús mostró su Corazón ardiente de amor coronado de espinas diciendo: 'He aquí el Corazón que tanto ha amado a los hombres...'",
            "Christ displayed His Sacred Heart aflame with unquenchable charity, promising infinite graces to those who venerate it.",
            "Jesus mostrou Seu Coração inflamado de amor, prometendo copiosas bênçãos a quem O honrar."
        ),
        promises = LocalizedText(
            "Paz en las familias, consuelo en las aflicciones, bendición en las empresas y la gracia de la salvación eterna.",
            "Peace in families, solace in tribulations, blessings on temporal tasks, and the supreme grace of final perseverance.",
            "Paz nos lares, consolo nas aflições e a salvação eterna."
        ),
        days = listOf(
            NovenaDay(
                dayNumber = 1,
                theme = LocalizedText("Día 1: El Amor Infinito del Corazón de Jesús", "Day 1: The Infinite Love of Christ's Heart", "Dia 1: O Amor Infinito do Coração de Jesus"),
                scripture = "1 Juan 4, 9-10",
                meditation = LocalizedText(
                    "Considera cómo el Corazón de Jesús nos amó primero, entregándose en la Cruz para rescatarnos del pecado y de la muerte eterna.",
                    "Contemplate how the Sacred Heart loved us first, submitting to the Cross to redeem us from sin and despair.",
                    "Medite sobre o amor imenso de Jesus, que Se entregou inteiramente na Cruz por nossa redenção."
                ),
                prayer = LocalizedText(
                    "¡Oh Corazón amabilísimo de Jesús, horno ardiente de divina caridad!: enciende mi alma en el fuego de tu amor. Haz que reconozca tu infinita bondad y concédeme la gracia que hoy te pido en esta novena... Sagrado Corazón de Jesús, en Ti confío.",
                    "O most lovable Heart of Jesus, burning furnace of charity: inflame my cold soul with the fire of Your divine love. Hear my earnest petition... Sacred Heart of Jesus, I place my trust in You.",
                    "Ó Coração amabilíssimo de Jesus, fornalha ardente de amor: inflamai o meu coração no Vosso santo amor. Sagrado Coração de Jesus, eu confio em Vós!"
                ),
                intentionGuidance = LocalizedText("Pon en el Corazón de Jesús tu petición principal y haz un acto de gratitud por su sacrificio en la Cruz.", "Place your primary intention into Christ's Heart and offer thanksgiving for His Passion.", "Apresente sua intenção e agradeça a Jesus pelo dom da vida.")
            ),
            NovenaDay(
                dayNumber = 2,
                theme = LocalizedText("Día 2: Jesús Manso y Humilde de Corazón", "Day 2: Meek & Humble of Heart", "Dia 2: Jesus Manso e Humilde de Coração"),
                scripture = "Mateo 11, 28-30",
                meditation = LocalizedText(
                    "«Aprendan de mí, que soy manso y humilde de corazón, y hallarán descanso para sus almas». La humildad de Cristo vence la soberbia del mundo.",
                    "“Learn from me, for I am meek and humble of heart; and you will find rest for yourselves.” Humility disarms the worldly spirit.",
                    "A mansidão de Jesus nos ensina a silenciar o orgulho e a acolher o descanso na Divina Providência."
                ),
                prayer = LocalizedText(
                    "¡Oh Jesús manso y humilde de corazón!: arranca de mi pecho todo resentimiento, ira y orgullo. Dame un corazón semejante al tuyo para amar a mis hermanos con paciencia evangélica. Amén.",
                    "O Jesus, meek and humble of heart: eradicate pride and anger from my soul. Grant me a heart molded to Yours in patient charity. Amen.",
                    "Jesus, manso e humilde de coração, fazei o meu coração semelhante ao Vosso e dai-me a virtude da santa paciência. Amém."
                ),
                intentionGuidance = LocalizedText("Pide la gracia de perdonar a quien te haya ofendido recientemente.", "Forgive sincerely anyone who has wounded you recently.", "Perdoe de coração a quem tenha ofendido você.")
            ),
            NovenaDay(
                dayNumber = 3,
                theme = LocalizedText("Día 3: El Corazón Eucarístico de Jesús", "Day 3: The Eucharistic Heart of Jesus", "Dia 3: O Coração Eucarístico de Jesus"),
                scripture = "Juan 6, 51-56",
                meditation = LocalizedText(
                    "En la Sagrada Eucaristía palpita el verdadero Corazón de Cristo. Allí nos espera de noche y de día en el Sagrario con amor silencioso y fiel.",
                    "In the Most Holy Eucharist, the physical Heart of Jesus beats perpetually in the tabernacle, awaiting our adoration.",
                    "No Santíssimo Sacramento do Altar bate o Coração vivo de Cristo, esperando nossa visita e amor."
                ),
                prayer = LocalizedText(
                    "¡Señor Jesús, presente en el Santísimo Sacramento!: te adoro con profunda reverencia. Perdona mi frialdad y atrae mi alma al banquete de tu altar. Amén.",
                    "Lord Jesus, truly present in the Blessed Sacrament: I adore You with deepest awe. Draw my soul to Eucharistic communion with You. Amen.",
                    "Senhor Jesus na Hóstia Santa: eu Vos adoro, amo e bendigo. Fazei-me amar a Santa Missa e a Comunhão frequente. Amém."
                ),
                intentionGuidance = LocalizedText("Haz una visita espiritual al Sagrario más cercano y ofrece una comunión reparadora.", "Offer spiritual communion to Christ present in the tabernacle.", "Faça uma comunhão espiritual em reparação às ofensas contra a Eucaristia.")
            ),
            NovenaDay(
                dayNumber = 4,
                theme = LocalizedText("Día 4: Reparación por las Ingratitudes", "Day 4: Reparation for Ingratitude", "Dia 4: Reparação pelas Ingratidões"),
                scripture = "Lucas 22, 41-44",
                meditation = LocalizedText(
                    "Jesús sufre en el Huerto de los Olivos por la indiferencia, sacrilegios y ofensas de los pecadores. Estamos llamados a ser sus consoladores.",
                    "In Gethsemane, Christ suffered agony not only for sin, but for the chilling ingratitude of souls He came to save.",
                    "No Getsêmani, Jesus experimentou a dor da ingratidão humana. Somos chamados a consolar Seu Coração ferido."
                ),
                prayer = LocalizedText(
                    "¡Oh Corazón ultrajado por mis pecados y los del mundo entero!: acepto este día como acto de reparación por tantas indiferencias hacia tu amor infinito. Amén.",
                    "O Sacred Heart wounded by human indifference: accept my daily sacrifices in reparation for the blasphemies and coldness of this world. Amen.",
                    "Coração de Jesus, ferido por nossos pecados: perdoai a nossa fraqueza e aceitai nosso ato de sincera reparação. Amém."
                ),
                intentionGuidance = LocalizedText("Ofrece un pequeño sacrificio o mortificación en desagravio al Sagrado Corazón.", "Offer a quiet mortification of your senses in reparation to Jesus.", "Ofereça um pequeno sacrifício cotidiano por amor a Jesus.")
            ),
            NovenaDay(
                dayNumber = 5,
                theme = LocalizedText("Día 5: Refugio en las Tentaciones y Tribulaciones", "Day 5: Sanctuary in Temptation & Trial", "Dia 5: Refúgio nas Tentações e Dores"),
                scripture = "Salmo 91, 1-4",
                meditation = LocalizedText(
                    "La llaga abierta del costado de Cristo es el asilo seguro donde ninguna potestad maligna puede arrebatarnos la paz del alma.",
                    "The pierced side of Christ is an impregnable fortress where no spiritual enemy can plunder our hope.",
                    "A chaga aberta do lado de Jesus é o refúgio seguro onde encontramos fortaleza contra as tentações."
                ),
                prayer = LocalizedText(
                    "¡En la llaga de tu Sagrado Corazón, oh Jesús, escóndeme!: líbrame de caer en el pecado mortal y protégeme de las asechanzas del maligno. Amén.",
                    "Within the wound of Your Sacred Heart, hide me, Lord Jesus! Preserve me from mortal sin and deliver me from the adversary's snare. Amen.",
                    "Dentro de Vossas santas Chagas, escondei-me, Jesus! Não permitais que eu me separe de Vós. Amém."
                ),
                intentionGuidance = LocalizedText("Invoca la Sangre de Cristo cuando sientas la menor insinuación de pecado.", "Invoke the Blood of Christ immediately upon the onset of temptation.", "Invoque o Sangue de Cristo diante de qualquer tentação.")
            ),
            NovenaDay(
                dayNumber = 6,
                theme = LocalizedText("Día 6: Salud y Consuelo de los Enfermos", "Day 6: Health & Comfort of the Afflicted", "Dia 6: Saúde e Consolo dos Enfermos"),
                scripture = "Mateo 8, 16-17",
                meditation = LocalizedText(
                    "Cristo asumió nuestras debilidades y cargó con nuestras dolencias. Su Corazón es bálsamo de consuelo para quienes sufren en el cuerpo o la mente.",
                    "Christ took away our infirmities and bore our diseases. His Heart pours restoring grace into broken bodies and minds.",
                    "Jesus passou pelo mundo curando enfermos e consolando os aflitos. Seu Coração é alívio para toda dor."
                ),
                prayer = LocalizedText(
                    "¡Médico celestial de las almas y los cuerpos!: pon tu mano sanadora sobre los enfermos de nuestras familias y concede paciencia redentora a quienes sufren. Amén.",
                    "Divine Healer of souls and bodies: lay Your restoring hand upon our afflicted loved ones, granting them healing and supernatural peace. Amen.",
                    "Senhor Jesus, consolai os doentes, aliviai suas dores e concedei-lhes a graça da santa recuperação. Amém."
                ),
                intentionGuidance = LocalizedText("Ora especialmente por un enfermo o anciano que sufra soledad.", "Pray specifically for someone in the hospital or struggling with chronic illness.", "Reze por um enfermo abandonado ou familiar doente.")
            ),
            NovenaDay(
                dayNumber = 7,
                theme = LocalizedText("Día 7: Paz en las Familias y en los Hogares", "Day 7: Peace in Families & Homes", "Dia 7: Paz nas Famílias e Lares"),
                scripture = "Colosenses 3, 12-15",
                meditation = LocalizedText(
                    "Una de las promesas de Jesús a Santa Margarita María: 'Pondré paz en sus familias y bendeciré los hogares donde esté expuesta y sea honrada la imagen de mi Sagrado Corazón'.",
                    "Jesus promised to establish peace in families and bless every home where the image of His Heart is exposed and venerated.",
                    "Jesus prometeu reinar com paz e bênçãos nos lares que consagrarem sua família ao Seu Sagrado Coração."
                ),
                prayer = LocalizedText(
                    "¡Rey y centro de todos los corazones!: consagro a tu Sagrado Corazón mi hogar, mi familia y mis seres queridos. Que reine en nosotros el perdón mutuo y la caridad cristiana. Amén.",
                    "King and Center of all hearts: I consecrate my home and family to Your Sacred Heart. Let domestic unity and mutual charity reign among us. Amen.",
                    "Sagrado Coração de Jesus, consagramos a Vós a nossa família. Reinai soberano em nossa casa e trazei-nos a paz. Amém."
                ),
                intentionGuidance = LocalizedText("Consagra hoy tu casa y tu familia al Corazón de Jesús.", "Enthrone or honor an image of the Sacred Heart in your home today.", "Coloque a imagem do Coração de Jesus em destaque em sua casa.")
            ),
            NovenaDay(
                dayNumber = 8,
                theme = LocalizedText("Día 8: Conversión de los Pecadores", "Day 8: Conversion of Sinners", "Dia 8: Conversão dos Pecadores"),
                scripture = "Lucas 15, 4-7",
                meditation = LocalizedText(
                    "El Corazón del Buen Pastor deja las noventa y nueve ovejas en el desierto para buscar a la perdida hasta encontrarla y cargarla sobre sus hombros con alegría.",
                    "The Good Shepherd leaves the ninety-nine in the desert to pursue the single lost sheep until He finds it and carries it home rejoicing.",
                    "O Bom Pastor busca incansavelmente a ovelha perdida. Não há pecado que supere a misericórdia de Cristo."
                ),
                prayer = LocalizedText(
                    "¡Buen Pastor Jesús!: toca con la gracia irresistible de tu Corazón a los pecadores empedernidos, a los alejados de la Iglesia y a quienes viven en la tibieza. Amén.",
                    "Good Shepherd Jesus: soften the hearts of hardened sinners, bring back fallen-away Catholics, and kindle the lukewarm with apostolic zeal. Amen.",
                    "Senhor Jesus, convertei os pecadores e trazei de volta ao Vosso aprisco aqueles que se afastaram da fé. Amém."
                ),
                intentionGuidance = LocalizedText("Ofrece el día de hoy por la conversión de un ser querido alejado de Dios.", "Offer today's prayers for an estranged friend or family member to return to confession.", "Reze pela conversão de um amigo ou parente afastado da Igreja.")
            ),
            NovenaDay(
                dayNumber = 9,
                theme = LocalizedText("Día 9: La Gran Promesa de la Perseverancia Final", "Day 9: The Supreme Promise of Eternal Life", "Dia 9: A Grande Promessa da Perseverança Final"),
                scripture = "Juan 10, 27-29",
                meditation = LocalizedText(
                    "«Yo les doy la vida eterna y no perecerán jamás, y nadie las arrebatará de mi mano». La devoción al Sagrado Corazón culmina en la santa muerte en gracia de Dios.",
                    "“I give them eternal life, and they shall never perish, and no one shall snatch them out of my hand.” Final perseverance is the crown of devotion.",
                    "A comunhão reparadora dos nove primeiros sextas-feiras nos assegura a graça da penitência final e o Céu."
                ),
                prayer = LocalizedText(
                    "¡Oh Jesús amadísimo!: por la infinita ternura de tu Corazón, concédeme la gracia de perseverar en tu amor hasta mi último aliento. No permitas que me separe de Ti por toda la eternidad. Amén.",
                    "O beloved Jesus: by the ocean of Your mercy, grant me the supreme grace of final perseverance. May I die in Your grace and behold Your glory forever. Amen.",
                    "Coração de Jesus, sede o meu refúgio seguro na vida e o meu amparo consolador na hora da morte. Amém."
                ),
                intentionGuidance = LocalizedText("Renueva tu promesa de comulgar los primeros viernes de mes en reparación.", "Renew your commitment to observe the Nine First Fridays devotion.", "Renove o propósito de comungar nas primeiras sextas-feiras do mês.")
            )
        )
    )

    val divineMercyNovena = Novena(
        id = "divine_mercy_novena",
        title = LocalizedText("Novena de la Divina Misericordia (Dictada a Santa Faustina)", "Novena of Divine Mercy (Dictated to St. Faustina)", "Novena da Divina Misericórdia"),
        patron = LocalizedText("Jesús Misericordioso", "Jesus the Divine Mercy", "Jesus Misericordioso"),
        category = LocalizedText("Misericordia y Salvación", "Mercy & Salvation", "Misericórdia e Salvação"),
        description = LocalizedText(
            "Novena dictada por Nuestro Señor Jesucristo a Santa Faustina Kowalska para rezarse preferentemente desde el Viernes Santo hasta la Fiesta de la Divina Misericordia.",
            "Nine-day Novena dictated personally by Jesus to Saint Faustina Kowalska, concluding on the Feast of Divine Mercy.",
            "Novena ditada por Jesus a Santa Faustina, trazendo cada dia um grupo diferente de almas ao Seu Coração misericordioso."
        ),
        miraculousHistory = LocalizedText(
            "Jesús prometió: 'Por medio de esta novena concederé a las almas toda clase de gracias...'",
            "Christ promised to Saint Faustina: 'During this novena I will grant to souls all kinds of graces...'",
            "Jesus prometeu derramar um oceano de graças sobre as almas que rezarem esta novena com confiança."
        ),
        promises = LocalizedText(
            "Remisión total de las culpas y penas en la Fiesta de la Misericordia, y protección en la hora de la muerte.",
            "Total remission of sins and punishments on Mercy Sunday, and angelic defense at the hour of death.",
            "Perdão total das culpas e penas e salvação eterna."
        ),
        days = listOf(
            NovenaDay(
                dayNumber = 1,
                theme = LocalizedText("Día 1: Por toda la humanidad y especialmente los pecadores", "Day 1: All Mankind, especially Sinners", "Dia 1: Toda a humanidade, especialmente os pecadores"),
                scripture = "Lucas 15, 10",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a toda la humanidad y especialmente a todos los pecadores, y sumérgelos en el mar de mi misericordia».",
                    "Jesus said: “Today bring to Me all mankind, especially all sinners, and immerse them in the ocean of My mercy.”",
                    "Jesus pede que mergulhemos em Sua misericórdia toda a humanidade, especialmente os pecadores."
                ),
                prayer = LocalizedText(
                    "Jesús misericordioso, cuya naturaleza es tener compasión de nosotros y perdonarnos: mira no nuestros pecados sino la confianza que depositamos en tu bondad infinita. Amén.",
                    "Most Merciful Jesus, whose very nature is to have compassion on us and to forgive us: look not upon our sins but upon our trust which we place in Your infinite goodness. Amen.",
                    "Misericordioso Jesus, cuja natureza é ter compaixão e perdoar: acolhei toda a humanidade no Vosso Coração. Amém."
                ),
                intentionGuidance = LocalizedText("Reza la Coronilla de la Divina Misericordia por los pecadores del mundo entero.", "Pray the Divine Mercy Chaplet for the salvation of all souls.", "Reze o Terço da Misericórdia pelos pecadores.")
            ),
            NovenaDay(
                dayNumber = 2,
                theme = LocalizedText("Día 2: Por las almas de los sacerdotes y religiosos", "Day 2: The Souls of Priests and Religious", "Dia 2: As almas dos sacerdotes e religiosos"),
                scripture = "Hebreos 5, 1-4",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a las almas de los sacerdotes y las almas de los religiosos, y sumérgelas en mi misericordia insondable».",
                    "Jesus said: “Today bring to Me the souls of priests and religious, and immerse them in My unfathomable mercy.”",
                    "Jesus nos convida a rezar com ardor pela santificação dos padres, bispos, monges e freiras."
                ),
                prayer = LocalizedText(
                    "Jesús misericordioso, de quien procede todo bien: multiplica la gracia en las almas consagradas a tu servicio para que puedan realizar dignas obras de misericordia. Amén.",
                    "Most Merciful Jesus, from whom comes all that is good: increase grace in men and women consecrated to Your service, that they may perform worthy works of mercy. Amen.",
                    "Jesus misericordioso: dai aos Vossos sacerdotes e religiosos a força de guiar o Vosso rebanho com santidade. Amém."
                ),
                intentionGuidance = LocalizedText("Ofrece tu oración por el Santo Padre y los sacerdotes de tu diócesis.", "Offer this day for the Pope, your bishop, and parish priests.", "Reze pela perseverança e santidade dos sacerdotes.")
            ),
            NovenaDay(
                dayNumber = 3,
                theme = LocalizedText("Día 3: Por todas las almas devotas y fieles", "Day 3: All Devout and Faithful Souls", "Dia 3: Todas as almas devotas e fiéis"),
                scripture = "Juan 19, 25-27",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a todas las almas devotas y fieles, y sumérgelas en el mar de mi misericordia. Estas almas me consolaron en el camino del Calvario».",
                    "Jesus said: “Today bring to Me all devout and faithful souls, and immerse them in the ocean of My mercy. These souls brought Me consolation on the Way of the Cross.”",
                    "As almas fiéis são as gotas de consolo que aliviaram a agonia de Cristo na Paixão."
                ),
                prayer = LocalizedText(
                    "Jesús misericordioso, que derramas tus gracias con tanta abundancia sobre todos: acoge a todas las almas fieles y no permitas que jamás se aparten de tu amor. Amén.",
                    "Most Merciful Jesus, who lavishly bestow Your graces on all: receive all faithful souls into the abode of Your most compassionate Heart. Amen.",
                    "Jesus compassivo: guardai os Vossos fiéis para que perseverem firmes na fé até o último suspiro. Amém."
                ),
                intentionGuidance = LocalizedText("Pide por la perseverancia final de los miembros de tu comunidad parroquial.", "Pray for the perseverance of all devout Catholic believers.", "Reze pelos fiéis de sua paróquia e pelos que sofrem perseguição.")
            ),
            NovenaDay(
                dayNumber = 4,
                theme = LocalizedText("Día 4: Por los que no creen en Dios y los que no conocen a Jesús", "Day 4: Those who do not Believe in God", "Dia 4: Os que não creem em Deus e não conhecem Jesus"),
                scripture = "1 Timoteo 2, 3-4",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a los que no creen en Dios y a aquellos que todavía no me conocen. Los rayos de mi corazón iluminen las tinieblas de su mente».",
                    "Jesus said: “Today bring to Me those who do not believe in God and those who do not yet know Me. May the rays of My Heart enlighten them.”",
                    "Deus quer que todos os homens se salvem e cheguem ao conhecimento da verdade."
                ),
                prayer = LocalizedText(
                    "Jesús compasivísimo, que eres la Luz del mundo entero: acoge en tu Corazón a los que aún no te conocen para que los rayos de tu gracia los iluminen y alaben contigo la eternidad. Amén.",
                    "Most compassionate Jesus, Light of the whole world: draw into Your Heart the souls of those who do not yet know You, that the brilliance of Your grace may illuminate their path. Amen.",
                    "Senhor Jesus, Luz das nações: iluminai aqueles que vivem no ateísmo ou ignorância religiosa. Amém."
                ),
                intentionGuidance = LocalizedText("Ora por los pueblos y personas que jamás han escuchado el Evangelio.", "Pray for missionary efforts and people living in secular materialism.", "Reze pela evangelização dos povos que ainda não conhecem a Cristo.")
            ),
            NovenaDay(
                dayNumber = 5,
                theme = LocalizedText("Día 5: Por las almas de los separados de la Iglesia", "Day 5: The Souls of Separated Brethren", "Dia 5: As almas dos irmãos separados"),
                scripture = "Juan 17, 20-21",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a las almas de los que se han separado de mi Iglesia, y sumérgelas en el mar de mi misericordia. Durante mi amarga Pasión desgarraron mi Cuerpo y mi Corazón, es decir, mi Iglesia».",
                    "Jesus said: “Today bring to Me the souls of those who have separated themselves from My Church... As they return to unity with the Church, My wounds heal.”",
                    "Jesus rezou na Última Ceia: 'Pai, que todos sejam um, como Tu e Eu somos um'."
                ),
                prayer = LocalizedText(
                    "Jesús infinitamente misericordioso, que eres la bondad misma: reúne en el redil de la única Iglesia que Tú fundaste a todos los hermanos separados para que haya un solo rebaño y un solo Pastor. Amén.",
                    "Most Merciful Jesus, Goodness Itself: look with mercy upon the souls of our separated brethren. Draw them by Your light back to the unity of the Catholic Church. Amen.",
                    "Jesus, Bom Pastor: guiai todos os cristãos à plenitude da unidade católica sob a verdade do Evangelho. Amém."
                ),
                intentionGuidance = LocalizedText("Ofrece esta jornada por la reconciliación y unidad de los cristianos en la Iglesia.", "Pray for authentic Christian unity rooted in apostolic truth.", "Reze pela unidade da Igreja e pelo diálogo fraterno.")
            ),
            NovenaDay(
                dayNumber = 6,
                theme = LocalizedText("Día 6: Por las almas mansas y humildes y los niños pequeños", "Day 6: The Meek, Humble & Children", "Dia 6: As almas mansas, humildes e as criancinhas"),
                scripture = "Mateo 18, 1-4",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a las almas mansas y humildes y las almas de los niños pequeños, y sumérgelas en mi misericordia. Estas almas son las más semejantes a mi Corazón».",
                    "Jesus said: “Today bring to Me the Meek and Humble Souls and the Souls of Little Children... These souls are the most similar to My Heart.”",
                    "As almas puras e humildes sobem ao trono de Deus como incenso aromático de adoração."
                ),
                prayer = LocalizedText(
                    "Jesús benignísimo, que dijiste: 'Dejen que los niños vengan a mí': guarda la inocencia de los niños, defiende a los no nacidos y llena a los humildes de la fragancia de tu paz. Amén.",
                    "Most Merciful Jesus, who said 'Let the little children come to Me': preserve the purity of the young, protect the unborn, and bestow on the humble the peace of heaven. Amen.",
                    "Jesus amigo das crianças: protegei a pureza dos pequeninos e dai-nos um coração simples e humilde. Amém."
                ),
                intentionGuidance = LocalizedText("Pide la defensa de los niños no nacidos y la pureza de la juventud.", "Pray for the protection of infants and children in danger.", "Reze pela proteção dos nascituros e crianças necessitadas.")
            ),
            NovenaDay(
                dayNumber = 7,
                theme = LocalizedText("Día 7: Por las almas que veneran la Divina Misericordia", "Day 7: Souls who Venerate My Mercy", "Dia 7: As almas que veneram a Divina Misericórdia"),
                scripture = "Salmo 89, 2",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a las almas que veneran y ensalzan de modo especial mi misericordia. Estas almas son copias vivas de mi Corazón compasivo».",
                    "Jesus said: “Today bring to Me the Souls who especially venerate and glorify My Mercy... They are living images of My compassionate Heart.”",
                    "Quem difunde a misericórdia de Jesus experimentará a Sua proteção especial na hora da morte."
                ),
                prayer = LocalizedText(
                    "Jesús compasivísimo, cuyo Corazón es el amor mismo: protege a las almas que proclaman la grandeza de tu misericordia. Defiéndelas en la hora de la muerte como tu propia gloria. Amén.",
                    "Most Merciful Jesus, whose Heart is Love itself: shield all who proclaim the greatness of Your Mercy. Be their refuge in life and their victory in death. Amen.",
                    "Senhor Jesus: abençoai todos os apóstolos da Vossa divina misericórdia e sustentai a sua missão com graça. Amém."
                ),
                intentionGuidance = LocalizedText("Promete dar a conocer la devoción a la Divina Misericordia a otra persona.", "Share the Divine Mercy devotion with someone going through darkness.", "Ensine a oração do Terço da Misericórdia a alguém.")
            ),
            NovenaDay(
                dayNumber = 8,
                theme = LocalizedText("Día 8: Por las benditas almas del Purgatorio", "Day 8: The Holy Souls in Purgatory", "Dia 8: As almas benditas do Purgatório"),
                scripture = "2 Macabeos 12, 43-46",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a las almas que están en la cárcel del Purgatorio y sumérgelas en el abismo de mi misericordia. Que los torrentes de mi Sangre apaguen sus llamas abrasadoras».",
                    "Jesus said: “Today bring to Me the Souls who are in the prison of Purgatory, and immerse them in the abyss of My mercy. Let the streams of My Blood cool down their scorching flames.”",
                    "As almas do Purgatório esperam com santa paciência a nossa oração e o Santo Sacrifício da Missa."
                ),
                prayer = LocalizedText(
                    "Jesús misericordioso, que dijiste: 'Misericordia quiero y no sacrificios': mira con clemencia a las benditas almas del Purgatorio y ábreles las puertas de la gloria celestial. Amén.",
                    "Most Merciful Jesus, who commanded us to love one another: relieve the holy souls suffering purification and admit them swiftly into the joy of Your presence. Amen.",
                    "Jesus compassivo: aliviai os sofrimentos das almas do Purgatório e concedei-lhes o descanso eterno no Paraíso. Amém."
                ),
                intentionGuidance = LocalizedText("Ofrece una indulgencia o el rezo del Rosario por los difuntos de tu familia.", "Offer a Rosary or obtain an indulgence for departed souls.", "Reze pelas almas dos falecidos de sua família e amigos.")
            ),
            NovenaDay(
                dayNumber = 9,
                theme = LocalizedText("Día 9: Por las almas tibias", "Day 9: Lukewarm & Indifferent Souls", "Dia 9: As almas tíbias"),
                scripture = "Apocalipsis 3, 15-16",
                meditation = LocalizedText(
                    "Jesús dice: «Hoy tráeme a las almas tibias y sumérgelas en el abismo de mi misericordia. Estas almas son las que más dolorosamente hieren mi Corazón. Por ellas exclamé en Getsemaní: 'Padre, si es posible, aparta de mí este cáliz'».",
                    "Jesus said: “Today bring to Me Souls who have become Lukewarm, and immerse them in the abyss of My mercy. These souls wound My Heart most painfully. My soul suffered the most dreadful loathing in the Garden of Olives because of lukewarm souls.”",
                    "A tibieza apaga o fervor do Espírito Santo. Jesus deseja acender nelas o fogo vivo de Seu amor."
                ),
                prayer = LocalizedText(
                    "Jesús compasivísimo, que eres la compasión misma: sumerge en el fuego de tu amor divino a las almas tibias. Que el ardor de tu Corazón vuelva a encender en ellas la llama viva de la caridad. Amén.",
                    "Most compassionate Jesus, who are Compassion Itself: immerse lukewarm souls in the fire of Your divine charity. Revive their deadened hearts with supernatural fervor. Amen.",
                    "Senhor Jesus: inflamai as almas frias e tíbias no ardor do Vosso Santo Espírito para que Vos amem com entusiasmo. Amém."
                ),
                intentionGuidance = LocalizedText("Haz un examen de conciencia sobre la tibieza y renueva tu fervor espiritual.", "Examine your own life for spiritual complacency and pray for zeal.", "Renove o fervor de sua oração e afaste toda preguiça espiritual.")
            )
        )
    )

    val allNovenas: List<Novena> = listOf(
        sacredHeartNovena,
        divineMercyNovena
    )
}
