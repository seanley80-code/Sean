package com.example.data

import com.example.model.ConversationCategory
import com.example.model.ConversationLine
import com.example.model.PhraseTranslation
import com.example.model.TopicIconType

internal val greetingsCategory = ConversationCategory(
    id = "greetings",
    titleKm = "សួរសុខទុក្ខ & ណែនាំខ្លួន",
    titleEn = "Greetings & Introductions",
    titleZh = "问候与自我介绍",
    subtitleKm = "ការស្វាគមន៍ សួរសុខទុក្ខ និងណែនាំឈ្មោះ",
    iconType = TopicIconType.GREETINGS,
    phrases = listOf(
        ConversationLine(
            id = "gr_1",
            categoryId = "greetings",
            speakerRoleKm = "អ្នកសួរ • ពេលព្រឹក",
            speakerRoleEn = "Speaker A • Morning",
            english = PhraseTranslation(
                text = "Good morning! How are you today?",
                romanizedOrPinyin = "/ɡʊd ˈmɔːrnɪŋ haʊ ɑːr juː təˈdeɪ/",
                khmerPhonetic = "ហ្គូដ ម័រនីង! ហៅ អារ យូ ធូដេ?"
            ),
            chinese = PhraseTranslation(
                text = "早上好！你今天好吗？",
                romanizedOrPinyin = "Zǎoshang hǎo! Nǐ jīntiān hǎo ma?",
                khmerPhonetic = "ចៅ សាំង ហៅ! នី ជីន ធាន ហៅ ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "អរុណសួស្តី! តើថ្ងៃនេះអ្នកសុខសប្បាយជាទេ?",
                romanizedOrPinyin = "Arun suostei! Tae thngai nih neak sok sabbay chea te?"
            )
        ),
        ConversationLine(
            id = "gr_2",
            categoryId = "greetings",
            speakerRoleKm = "អ្នកឆ្លើយ • សុខសប្បាយ",
            speakerRoleEn = "Speaker B • Reply",
            english = PhraseTranslation(
                text = "I am doing great, thank you. And you?",
                romanizedOrPinyin = "/aɪ æm ˈduːɪŋ ɡreɪt ˈθæŋk juː ænd juː/",
                khmerPhonetic = "អាយ អ៊ែម ឌូអ៊ីង ហ្គ្រេត សែងឃ្យូ អ៊ែន យូ?"
            ),
            chinese = PhraseTranslation(
                text = "我很好，谢谢。你呢？",
                romanizedOrPinyin = "Wǒ hěn hǎo, xièxie. Nǐ ne?",
                khmerPhonetic = "វ៉ ហិន ហៅ សៀកសៀក នី ណឺ?"
            ),
            khmer = PhraseTranslation(
                text = "ខ្ញុំសុខសប្បាយទេ អរគុណ! ចុះអ្នកវិញ?",
                romanizedOrPinyin = "Knhom sok sabbay te, orkun! Choh neak vinh?"
            )
        ),
        ConversationLine(
            id = "gr_3",
            categoryId = "greetings",
            speakerRoleKm = "ណែនាំឈ្មោះ",
            speakerRoleEn = "Introducing Name",
            english = PhraseTranslation(
                text = "Nice to meet you. My name is Dara.",
                romanizedOrPinyin = "/naɪs tuː miːt juː maɪ neɪm ɪz ˈdɑːrə/",
                khmerPhonetic = "ណាយស៍ ធូ មីត យូ ម៉ាយ ណេម អ៊ីស ដារ៉ា"
            ),
            chinese = PhraseTranslation(
                text = "很高兴认识你。我叫达拉。",
                romanizedOrPinyin = "Hěn gāoxìng rènshi nǐ. Wǒ jiào Dálā.",
                khmerPhonetic = "ហិន កាវស៊ីង រិនស៊ឺ នី វ៉ ចាវ តាឡា"
            ),
            khmer = PhraseTranslation(
                text = "រីករាយដែលបានស្គាល់អ្នក! ខ្ញុំឈ្មោះ ដារ៉ា។",
                romanizedOrPinyin = "Rikreay dael ban skoal neak! Knhom chhmoh Dara."
            )
        ),
        ConversationLine(
            id = "gr_4",
            categoryId = "greetings",
            speakerRoleKm = "សួរប្រទេសកំណើត",
            speakerRoleEn = "Asking Origin",
            english = PhraseTranslation(
                text = "Where are you from?",
                romanizedOrPinyin = "/weər ɑːr juː frɒm/",
                khmerPhonetic = "វែរ អារ យូ ហ្វ្រម?"
            ),
            chinese = PhraseTranslation(
                text = "你是哪里人？",
                romanizedOrPinyin = "Nǐ shì nǎlǐ rén?",
                khmerPhonetic = "នី ស៊ឺ ណាលី រិន?"
            ),
            khmer = PhraseTranslation(
                text = "តើអ្នកមកពីប្រទេសណាដែរ?",
                romanizedOrPinyin = "Tae neak mok pi brates na dae?"
            )
        ),
        ConversationLine(
            id = "gr_5",
            categoryId = "greetings",
            speakerRoleKm = "ឆ្លើយប្រទេស",
            speakerRoleEn = "Origin Reply",
            english = PhraseTranslation(
                text = "I am from Cambodia. I live in Phnom Penh.",
                romanizedOrPinyin = "/aɪ æm frɒm kæmˈboʊdiə aɪ lɪv ɪn pəˈnɒm ˈpɛn/",
                khmerPhonetic = "អាយ អ៊ែម ហ្វ្រម ខេមបូឌា អាយ លីវ អ៊ីន ភ្នំពេញ"
            ),
            chinese = PhraseTranslation(
                text = "我来自柬埔寨，我住在金边。",
                romanizedOrPinyin = "Wǒ láizì Jiǎnpǔzhài, wǒ zhù zài Jīnbiān.",
                khmerPhonetic = "វ៉ ឡាយជឺ ជានភូចាយ វ៉ ជូ ចាយ ជីនបៀន"
            ),
            khmer = PhraseTranslation(
                text = "ខ្ញុំមកពីប្រទេសកម្ពុជា។ ខ្ញុំរស់នៅទីក្រុងភ្នំពេញ។",
                romanizedOrPinyin = "Knhom mok pi brates Kampuchea. Knhom ruos nov tikrong Phnom Penh."
            )
        ),
        ConversationLine(
            id = "gr_6",
            categoryId = "greetings",
            speakerRoleKm = "ការលាគ្នា",
            speakerRoleEn = "Saying Goodbye",
            english = PhraseTranslation(
                text = "See you tomorrow! Have a nice day.",
                romanizedOrPinyin = "/siː juː təˈmɒroʊ hæv ə naɪs deɪ/",
                khmerPhonetic = "ស៊ី យូ ធូម័ររ៉ូ! ហែវ អឺ ណាយស៍ ដេ"
            ),
            chinese = PhraseTranslation(
                text = "明天见！祝你今天愉快。",
                romanizedOrPinyin = "Míngtiān jiàn! Zhù nǐ jīntiān yúkuài.",
                khmerPhonetic = "មីងធាន ជាន! ជូ នី ជីនធាន យីខ្វាយ"
            ),
            khmer = PhraseTranslation(
                text = "ជួបគ្នាថ្ងៃស្អែក! សូមជូនពរឱ្យមានថ្ងៃល្អ។",
                romanizedOrPinyin = "Chuob knea thngai saek! Soum chunpor oy mean thngai l'or."
            )
        )
    )
)

internal val diningCategory = ConversationCategory(
    id = "dining",
    titleKm = "ភោជនីយដ្ឋាន & អាហារ",
    titleEn = "Dining & Ordering Food",
    titleZh = "餐厅点餐",
    subtitleKm = "ការកុម្ម៉ង់ម្ហូប សួររសជាតិ និងគិតលុយ",
    iconType = TopicIconType.DINING,
    phrases = listOf(
        ConversationLine(
            id = "dn_1",
            categoryId = "dining",
            speakerRoleKm = "ចូលហាង • សុំតុ",
            speakerRoleEn = "Entering • Table",
            english = PhraseTranslation(
                text = "A table for two people, please.",
                romanizedOrPinyin = "/ə ˈteɪbəl fɔːr tuː ˈpiːpəl pliːz/",
                khmerPhonetic = "អឺ ថេបូល ហ្វ័រ ធូ ភីភូល ភ្លីស"
            ),
            chinese = PhraseTranslation(
                text = "请给我们一张两人桌。",
                romanizedOrPinyin = "Qǐng gěi wǒmen yì zhāng liǎngrén zhuō.",
                khmerPhonetic = "ឈីង កី វ៉មិន អ៊ី ចាង លាំងរិន ជួ"
            ),
            khmer = PhraseTranslation(
                text = "សូមរៀបចំតុសម្រាប់មនុស្សពីរនាក់។",
                romanizedOrPinyin = "Soum riebcham tok samrab monuh pir neak."
            )
        ),
        ConversationLine(
            id = "dn_2",
            categoryId = "dining",
            speakerRoleKm = "សុំមើលម៉ឺនុយ",
            speakerRoleEn = "Asking Menu",
            english = PhraseTranslation(
                text = "May I see the menu, please?",
                romanizedOrPinyin = "/meɪ aɪ siː ðə ˈmɛnjuː pliːz/",
                khmerPhonetic = "មេ អាយ ស៊ី ដឹ ម៉េនញូ ភ្លីស?"
            ),
            chinese = PhraseTranslation(
                text = "请给我看一下菜单好吗？",
                romanizedOrPinyin = "Qǐng gěi wǒ kàn yíxià càidān hǎo ma?",
                khmerPhonetic = "ឈីង កី វ៉ ខាន់ អ៊ីស៊ា ឆាយតាន ហៅ ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "តើខ្ញុំអាចសុំមើលបញ្ជីមុខម្ហូបបានទេ?",
                romanizedOrPinyin = "Tae knhom ach soum moel banhchi mok mhoub ban te?"
            )
        ),
        ConversationLine(
            id = "dn_3",
            categoryId = "dining",
            speakerRoleKm = "សួរម្ហូបឆ្ងាញ់",
            speakerRoleEn = "Recommendation",
            english = PhraseTranslation(
                text = "What is your most popular dish here?",
                romanizedOrPinyin = "/wɒt ɪz jɔːr moʊst ˈpɒpjələr dɪʃ hɪər/",
                khmerPhonetic = "វ៉ាត់ អ៊ីស យ័រ ម៉ូស្ត ផប់ព្យូល័រ ឌីស ហៀរ?"
            ),
            chinese = PhraseTranslation(
                text = "这里最受欢迎的菜是什么？",
                romanizedOrPinyin = "Zhèlǐ zuì shòu huānyíng de cài shì shénme?",
                khmerPhonetic = "ជឺលី ជួយ សូវ ហ្វានយីង តឺ ឆាយ ស៊ឺ ស៊ិនម៉ឺ?"
            ),
            khmer = PhraseTranslation(
                text = "តើម្ហូបណាដែលឆ្ងាញ់ និងពេញនិយមជាងគេនៅទីនេះ?",
                romanizedOrPinyin = "Tae mhoub na dael chhnganh ning penh niyom cheang ke nov tineh?"
            )
        ),
        ConversationLine(
            id = "dn_4",
            categoryId = "dining",
            speakerRoleKm = "បញ្ជាក់រសជាតិ",
            speakerRoleEn = "Taste Preference",
            english = PhraseTranslation(
                text = "Not too spicy, and less sugar, please.",
                romanizedOrPinyin = "/nɒt tuː ˈspaɪsi ænd lɛs ˈʃʊɡər pliːz/",
                khmerPhonetic = "ណត់ ធូ ស្ពាយស៊ី អ៊ែន ឡេស ស៊ូហ្គ័រ ភ្លីស"
            ),
            chinese = PhraseTranslation(
                text = "请不要太辣，少放一点糖。",
                romanizedOrPinyin = "Qǐng búyào tài là, shǎo fàng yìdiǎn táng.",
                khmerPhonetic = "ឈីង ពូយ៉ាវ ថាយ ឡា សាវ ហ្វាង អ៊ីទាន ថាង"
            ),
            khmer = PhraseTranslation(
                text = "សូមកុំហឹរពេក ហើយបន្ថយស្ករបន្តិច។",
                romanizedOrPinyin = "Soum kom hoer pek, haey banthoy skor bantech."
            )
        ),
        ConversationLine(
            id = "dn_5",
            categoryId = "dining",
            speakerRoleKm = "សរសើរម្ហូប",
            speakerRoleEn = "Compliment",
            english = PhraseTranslation(
                text = "The food is very delicious!",
                romanizedOrPinyin = "/ðə fuːd ɪz ˈvɛri dɪˈlɪʃəs/",
                khmerPhonetic = "ដឹ ហ្វូដ អ៊ីស វែរី ឌីលីសឹស!"
            ),
            chinese = PhraseTranslation(
                text = "这顿饭非常好吃！",
                romanizedOrPinyin = "Zhè dùn fàn fēicháng hǎochī!",
                khmerPhonetic = "ជឺ ទុន ហ្វាន ហ្វីឆាង ហៅឈឺ!"
            ),
            khmer = PhraseTranslation(
                text = "ម្ហូបនេះពិតជាឆ្ងាញ់ខ្លាំងណាស់!",
                romanizedOrPinyin = "Mhoub nih pit chea chhnganh khlang nah!"
            )
        ),
        ConversationLine(
            id = "dn_6",
            categoryId = "dining",
            speakerRoleKm = "គិតលុយ",
            speakerRoleEn = "Asking Bill",
            english = PhraseTranslation(
                text = "Excuse me, can we have the bill, please?",
                romanizedOrPinyin = "/ɪkˈskjuːz miː kæn wiː hæv ðə bɪl pliːz/",
                khmerPhonetic = "អ៊ិកស្គ្យូស មី ខែន វី ហែវ ដឹ ប៊ីល ភ្លីស?"
            ),
            chinese = PhraseTranslation(
                text = "不好意思，请结账好吗？",
                romanizedOrPinyin = "Bù hǎoyìsi, qǐng jiézhàng hǎo ma?",
                khmerPhonetic = "ពូ ហៅអ៊ីស៊ឺ ឈីង ជៀចាង ហៅ ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "សុំទោស! សូមគិតលុយផង។",
                romanizedOrPinyin = "Soum toh! Soum kit luy phong."
            )
        )
    )
)

internal val shoppingCategory = ConversationCategory(
    id = "shopping",
    titleKm = "ទិញទំនិញ & តម្លៃ",
    titleEn = "Shopping & Bargaining",
    titleZh = "购物与讲价",
    subtitleKm = "សួរតម្លៃ សុំបញ្ចុះតម្លៃ និងទូទាត់ប្រាក់",
    iconType = TopicIconType.SHOPPING,
    phrases = listOf(
        ConversationLine(
            id = "sh_1",
            categoryId = "shopping",
            speakerRoleKm = "សួរតម្លៃ",
            speakerRoleEn = "Asking Price",
            english = PhraseTranslation(
                text = "Excuse me, how much does this cost?",
                romanizedOrPinyin = "/ɪkˈskjuːz miː haʊ mʌtʃ dʌz ðɪs kɒst/",
                khmerPhonetic = "អ៊ិកស្គ្យូស មី ហៅ ម៉ាច់ ដាស ឌីស ខស្ត?"
            ),
            chinese = PhraseTranslation(
                text = "请问，这个多少钱？",
                romanizedOrPinyin = "Qǐngwèn, zhège duōshao qián?",
                khmerPhonetic = "ឈីងវិន ជឺកឺ តួសាវ ឈាន?"
            ),
            khmer = PhraseTranslation(
                text = "សុំទោស តើរបស់នេះតម្លៃប៉ុន្មាន?",
                romanizedOrPinyin = "Soum toh, tae robos nih tamlay ponman?"
            )
        ),
        ConversationLine(
            id = "sh_2",
            categoryId = "shopping",
            speakerRoleKm = "សុំបញ្ចុះតម្លៃ",
            speakerRoleEn = "Discount",
            english = PhraseTranslation(
                text = "It is a bit expensive. Can you give a discount?",
                romanizedOrPinyin = "/ɪt ɪz ə bɪt ɪkˈspɛnsɪv kæn juː ɡɪv ə ˈdɪskaʊnt/",
                khmerPhonetic = "អ៊ិត អ៊ីស អឺ ប៊ីត អ៊ិកស្ពែនស៊ីវ ខែន យូ ហ្គីវ អឺ ឌីសខោន?"
            ),
            chinese = PhraseTranslation(
                text = "有一点贵，可以便宜一点吗？",
                romanizedOrPinyin = "Yǒu yìdiǎn guì, kěyǐ piányi yìdiǎn ma?",
                khmerPhonetic = "យ៉ូវ អ៊ីទាន គួយ ខឺអ៊ី ភានអ៊ី អ៊ីទាន ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "វារាងថ្លៃបន្តិចហើយ។ តើអាចបញ្ចុះតម្លៃបានទេ?",
                romanizedOrPinyin = "Vea reang thlay bantech haey. Tae ach banhchoh tamlay ban te?"
            )
        ),
        ConversationLine(
            id = "sh_3",
            categoryId = "shopping",
            speakerRoleKm = "សួរទំហំ និងពណ៌",
            speakerRoleEn = "Size & Color",
            english = PhraseTranslation(
                text = "Do you have a larger size in blue?",
                romanizedOrPinyin = "/duː juː hæv ə ˈlɑːrdʒər saɪz ɪn bluː/",
                khmerPhonetic = "ឌូ យូ ហែវ អឺ ឡាជ័រ សាយស៍ អ៊ីន ប្ល៊ូ?"
            ),
            chinese = PhraseTranslation(
                text = "你们有大一点的蓝色吗？",
                romanizedOrPinyin = "Nǐmen yǒu dà yìdiǎn de lánsè ma?",
                khmerPhonetic = "នីមិន យ៉ូវ តា អ៊ីទាន តឺ ឡានសឺ ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "តើអ្នកមានទំហំធំជាងនេះពណ៌ខៀវទេ?",
                romanizedOrPinyin = "Tae neak mean tomhom thom cheang nih poa khiev te?"
            )
        ),
        ConversationLine(
            id = "sh_4",
            categoryId = "shopping",
            speakerRoleKm = "សុំសាកល្បង",
            speakerRoleEn = "Trying On",
            english = PhraseTranslation(
                text = "Can I try this on first?",
                romanizedOrPinyin = "/kæn aɪ traɪ ðɪs ɒn fɜːrst/",
                khmerPhonetic = "ខែន អាយ ត្រាយ ឌីស អន ហ្វើស្ត?"
            ),
            chinese = PhraseTranslation(
                text = "我可以先试穿一下吗？",
                romanizedOrPinyin = "Wǒ kěyǐ xiān shìchuān yíxià ma?",
                khmerPhonetic = "វ៉ ខឺអ៊ី សៀន ស៊ឺឈាន់ អ៊ីស៊ា ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "តើខ្ញុំអាចសាកពាក់មើលសិនបានទេ?",
                romanizedOrPinyin = "Tae knhom ach sak peak moel sen ban te?"
            )
        ),
        ConversationLine(
            id = "sh_5",
            categoryId = "shopping",
            speakerRoleKm = "ការទូទាត់ប្រាក់",
            speakerRoleEn = "Payment",
            english = PhraseTranslation(
                text = "I will take this one. Can I pay by QR code?",
                romanizedOrPinyin = "/aɪ wɪl teɪk ðɪs wʌn kæn aɪ peɪ baɪ kjuː ɑːr koʊd/",
                khmerPhonetic = "អាយ វីល ថេក ឌីស វ៉ាន់ ខែន អាយ ផេ បាយ ឃ្យូអារ ខូដ?"
            ),
            chinese = PhraseTranslation(
                text = "我要买这个。可以扫码付款吗？",
                romanizedOrPinyin = "Wǒ yào mǎi zhège. Kěyǐ sǎomǎ fùkuǎn ma?",
                khmerPhonetic = "វ៉ យ៉ាវ ម៉ាយ ជឺកឺ ខឺអ៊ី សាវម៉ា ហ្វូខ្វាន់ ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "ខ្ញុំយកមួយនេះ។ តើអាចស្កេន QR បង់ប្រាក់បានទេ?",
                romanizedOrPinyin = "Knhom yok muoy nih. Tae ach scan QR bang brak ban te?"
            )
        )
    )
)

internal val travelCategory = ConversationCategory(
    id = "travel",
    titleKm = "ធ្វើដំណើរ & សួរផ្លូវ",
    titleEn = "Travel & Directions",
    titleZh = "出行与问路",
    subtitleKm = "ហៅឡាន សួរផ្លូវ សណ្ឋាគារ និងព្រលានយន្តហោះ",
    iconType = TopicIconType.TRAVEL,
    phrases = listOf(
        ConversationLine(
            id = "tr_1",
            categoryId = "travel",
            speakerRoleKm = "សួរផ្លូវ",
            speakerRoleEn = "Asking Way",
            english = PhraseTranslation(
                text = "Excuse me, where is the nearest subway station?",
                romanizedOrPinyin = "/ɪkˈskjuːz miː weər ɪz ðə ˈnɪərɪst ˈsʌbweɪ ˈsteɪʃən/",
                khmerPhonetic = "អ៊ិកស្គ្យូស មី វែរ អ៊ីស ដឹ នៀរីស្ត សាប់វេ ស្ទេសិន?"
            ),
            chinese = PhraseTranslation(
                text = "请问，最近的地铁站在哪里？",
                romanizedOrPinyin = "Qǐngwèn, zuìjìn de dìtiězhàn zài nǎlǐ?",
                khmerPhonetic = "ឈីងវិន ជួយជីន តឺ ទីធៀចាន់ ចាយ ណាលី?"
            ),
            khmer = PhraseTranslation(
                text = "សុំទោស តើស្ថានីយ៍រថភ្លើងក្រោមដីនៅជិតបំផុតឯណា?",
                romanizedOrPinyin = "Soum toh, tae sthani rothphloeng kraomdey nov chhit bamphot ena?"
            )
        ),
        ConversationLine(
            id = "tr_2",
            categoryId = "travel",
            speakerRoleKm = "ប្រាប់អ្នកបើកឡាន",
            speakerRoleEn = "To Driver",
            english = PhraseTranslation(
                text = "Please take me to this address.",
                romanizedOrPinyin = "/pliːz teɪk miː tuː ðɪs ˈædrɛs/",
                khmerPhonetic = "ភ្លីស ថេក មី ធូ ឌីស អ៊ែដដ្រេស"
            ),
            chinese = PhraseTranslation(
                text = "请送我去这个地址。",
                romanizedOrPinyin = "Qǐng sòng wǒ qù zhège dìzhǐ.",
                khmerPhonetic = "ឈីង សុង វ៉ ឈី ជឺកឺ ទីជឺ"
            ),
            khmer = PhraseTranslation(
                text = "សូមជួយជូនខ្ញុំទៅអាសយដ្ឋាននេះផង។",
                romanizedOrPinyin = "Soum chuoy chun knhom tov asayathan nih phong."
            )
        ),
        ConversationLine(
            id = "tr_3",
            categoryId = "travel",
            speakerRoleKm = "សួរពេលវេលា",
            speakerRoleEn = "Duration",
            english = PhraseTranslation(
                text = "How long does it take to get to the airport?",
                romanizedOrPinyin = "/haʊ lɒŋ dʌz ɪt teɪk tuː ɡɛt tuː ði ˈɛərpɔːrt/",
                khmerPhonetic = "ហៅ ឡង ដាស អ៊ិត ថេក ធូ ហ្គេត ធូ ឌី អ៊ែរផត?"
            ),
            chinese = PhraseTranslation(
                text = "到机场需要多长时间？",
                romanizedOrPinyin = "Dào jīchǎng xūyào duō cháng shíjiān?",
                khmerPhonetic = "តាវ ជីឆាង ស៊ីយ៉ាវ តួ ឆាង ស៊ឺជាន?"
            ),
            khmer = PhraseTranslation(
                text = "តើទៅព្រលានយន្តហោះត្រូវចំណាយពេលប៉ុន្មាននាទី?",
                romanizedOrPinyin = "Tae tov prolean yontoh trov chamnay pel ponman neati?"
            )
        ),
        ConversationLine(
            id = "tr_4",
            categoryId = "travel",
            speakerRoleKm = "សណ្ឋាគារ",
            speakerRoleEn = "Hotel Check-in",
            english = PhraseTranslation(
                text = "I have a reservation under the name Sokha.",
                romanizedOrPinyin = "/aɪ hæv ə ˌrɛzərˈveɪʃən ˈʌndər ðə neɪm ˈsoʊkɑː/",
                khmerPhonetic = "អាយ ហែវ អឺ រ៉េស័រវេសិន អាន់ដឺ ដឹ ណេម សុខា"
            ),
            chinese = PhraseTranslation(
                text = "我预订了房间，名字叫索卡。",
                romanizedOrPinyin = "Wǒ yùdìng le fángjiān, míngzi jiào Suǒkǎ.",
                khmerPhonetic = "វ៉ យីទីង លឺ ហ្វាងជាន មីងជឺ ចាវ សួខា"
            ),
            khmer = PhraseTranslation(
                text = "ខ្ញុំបានកក់បន្ទប់រួចហើយ ក្នុងឈ្មោះ សុខា។",
                romanizedOrPinyin = "Knhom ban kok bantob ruoch haey, knong chhmoh Sokha."
            )
        ),
        ConversationLine(
            id = "tr_5",
            categoryId = "travel",
            speakerRoleKm = "សុំបង្ហាញផ្លូវ",
            speakerRoleEn = "Turn Left/Right",
            english = PhraseTranslation(
                text = "Go straight ahead, then turn right at the traffic light.",
                romanizedOrPinyin = "/ɡoʊ streɪt əˈhɛd ðɛn tɜːrn raɪt æt ðə ˈtræfɪk laɪt/",
                khmerPhonetic = "ហ្គោ ស្ត្រេត អឹហេដ ដេន ធើន រ៉ាយត៍ អ៊ែត ដឹ ត្រាហ្វិក ឡាយត៍"
            ),
            chinese = PhraseTranslation(
                text = "一直往前走，然后在红绿灯处右转。",
                romanizedOrPinyin = "Yìzhí wǎng qián zǒu, ránhòu zài hónglǜdēng chù yòu zhuǎn.",
                khmerPhonetic = "អ៊ីជឺ វ៉ាង ឈាន ចូវ រ៉ាន់ហូវ ចាយ ហុងលីតឹង ឈូ យ៉ូវ ជាន់"
            ),
            khmer = PhraseTranslation(
                text = "ទៅត្រង់ទៅមុខ រួចបត់ស្តាំនៅត្រង់ភ្លើងស្តុប។",
                romanizedOrPinyin = "Tov trang tov mukh, ruoch bot sdam nov trang phloeng stop."
            )
        )
    )
)
