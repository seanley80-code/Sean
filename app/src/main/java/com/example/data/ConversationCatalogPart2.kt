package com.example.data

import com.example.model.ConversationCategory
import com.example.model.ConversationLine
import com.example.model.PhraseTranslation
import com.example.model.TopicIconType

internal val workCategory = ConversationCategory(
    id = "work",
    titleKm = "ការងារ & អាជីវកម្ម",
    titleEn = "Work & Office",
    titleZh = "工作与商务",
    subtitleKm = "ការប្រជុំ ការសហការ និងការទំនាក់ទំនងការងារ",
    iconType = TopicIconType.WORK,
    phrases = listOf(
        ConversationLine(
            id = "wk_1",
            categoryId = "work",
            speakerRoleKm = "ណាត់ប្រជុំ",
            speakerRoleEn = "Scheduling",
            english = PhraseTranslation(
                text = "Are you free for a quick meeting this afternoon?",
                romanizedOrPinyin = "/ɑːr juː friː fɔːr ə kwɪk ˈmiːtɪŋ ðɪs ˌæftərˈnuːn/",
                khmerPhonetic = "អារ យូ ហ្វ្រី ហ្វ័រ អឺ ឃ្វីក មីធីង ឌីស អាហ្វធ័រនូន?"
            ),
            chinese = PhraseTranslation(
                text = "你今天下午有空开个短会吗？",
                romanizedOrPinyin = "Nǐ jīntiān xiàwǔ yǒukòng kāi gè duǎnhuì ma?",
                khmerPhonetic = "នី ជីនធាន ស៊ាវូ យ៉ូវខុង ខាយ កឺ តាន់ហួយ ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "តើរសៀលនេះអ្នកទំនេរដើម្បីប្រជុំមួយភ្លែតទេ?",
                romanizedOrPinyin = "Tae rosiel nih neak tomne daembi prachum muoy phlaet te?"
            )
        ),
        ConversationLine(
            id = "wk_2",
            categoryId = "work",
            speakerRoleKm = "សុំពន្យល់ម្តងទៀត",
            speakerRoleEn = "Clarifying",
            english = PhraseTranslation(
                text = "Could you please explain that one more time?",
                romanizedOrPinyin = "/kʊd juː pliːz ɪkˈspleɪn ðæt wʌn mɔːr taɪm/",
                khmerPhonetic = "ឃូដ យូ ភ្លីស អ៊ិកស្ព្លេន ដេត វ៉ាន់ ម័រ ថាម?"
            ),
            chinese = PhraseTranslation(
                text = "您可以再解释一遍吗？",
                romanizedOrPinyin = "Nín kěyǐ zài jiěshì yíbiàn ma?",
                khmerPhonetic = "នីន ខឺអ៊ី ចាយ ជៀស៊ឺ អ៊ីបៀន ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "តើអ្នកអាចជួយពន្យល់ចំណុចនោះម្តងទៀតបានទេ?",
                romanizedOrPinyin = "Tae neak ach chuoy ponyol chamnoch nuh mdong tiet ban te?"
            )
        ),
        ConversationLine(
            id = "wk_3",
            categoryId = "work",
            speakerRoleKm = "ផ្ញើឯកសារ",
            speakerRoleEn = "Sending Files",
            english = PhraseTranslation(
                text = "I have already sent the report to your email.",
                romanizedOrPinyin = "/aɪ hæv ɔːlˈrɛdi sɛnt ðə rɪˈpɔːrt tuː jɔːr ˈiːmeɪl/",
                khmerPhonetic = "អាយ ហែវ អលរេឌី សេនត៍ ដឹ រីផត ធូ យ័រ អ៊ីមែល"
            ),
            chinese = PhraseTranslation(
                text = "我已经把报告发到你的邮箱了。",
                romanizedOrPinyin = "Wǒ yǐjīng bǎ bàogào fā dào nǐ de yóuxiāng le.",
                khmerPhonetic = "វ៉ អ៊ីជីង ប៉ា ប៉ាវកាវ ហ្វា តាវ នី តឺ យ៉ូវស៊ាង លឺ"
            ),
            khmer = PhraseTranslation(
                text = "ខ្ញុំបានផ្ញើរបាយការណ៍ទៅអ៊ីមែលរបស់អ្នករួចហើយ។",
                romanizedOrPinyin = "Knhom ban phnhoe robaykar tov email robos neak ruoch haey."
            )
        ),
        ConversationLine(
            id = "wk_4",
            categoryId = "work",
            speakerRoleKm = "អរគុណក្រុមការងារ",
            speakerRoleEn = "Teamwork",
            english = PhraseTranslation(
                text = "Thank you so much for your hard work today.",
                romanizedOrPinyin = "/θæŋk juː soʊ mʌtʃ fɔːr jɔːr hɑːrd wɜːrk təˈdeɪ/",
                khmerPhonetic = "សែងឃ្យូ សូ ម៉ាច់ ហ្វ័រ យ័រ ហាដ វើក ធូដេ"
            ),
            chinese = PhraseTranslation(
                text = "非常感谢你今天的辛勤工作。",
                romanizedOrPinyin = "Fēicháng gǎnxiè nǐ jīntiān de xīnqín gōngzuò.",
                khmerPhonetic = "ហ្វីឆាង កាន់សៀ នី ជីនធាន តឺ ស៊ីនឈីន កុងជួ"
            ),
            khmer = PhraseTranslation(
                text = "សូមអរគុណច្រើនសម្រាប់ការខិតខំប្រឹងប្រែងរបស់អ្នកថ្ងៃនេះ។",
                romanizedOrPinyin = "Soum orkun chraen samrab kar khetkhom proengpraeng robos neak thngai nih."
            )
        )
    )
)

internal val healthCategory = ConversationCategory(
    id = "health",
    titleKm = "សុខភាព & ឱសថស្ថាន",
    titleEn = "Health & Pharmacy",
    titleZh = "健康与药店",
    subtitleKm = "ប្រាប់អាការៈឈឺ ទិញថ្នាំ និងជួបគ្រូពេទ្យ",
    iconType = TopicIconType.HEALTH,
    phrases = listOf(
        ConversationLine(
            id = "hl_1",
            categoryId = "health",
            speakerRoleKm = "ប្រាប់អាការៈ",
            speakerRoleEn = "Feeling Unwell",
            english = PhraseTranslation(
                text = "I am not feeling well. I have a fever and headache.",
                romanizedOrPinyin = "/aɪ æm nɒt ˈfiːlɪŋ wɛl aɪ hæv ə ˈfiːvər ænd ˈhɛdeɪk/",
                khmerPhonetic = "អាយ អ៊ែម ណត់ ហ្វីលីង វែល អាយ ហែវ អឺ ហ្វីវ័រ អ៊ែន ហេដអេក"
            ),
            chinese = PhraseTranslation(
                text = "我觉得不舒服，我发烧而且头疼。",
                romanizedOrPinyin = "Wǒ juéde bù shūfu, wǒ fāshāo érqiě tóuténg.",
                khmerPhonetic = "វ៉ ជៀតឺ ពូ ស៊ូហ្វូ វ៉ ហ្វាសាវ អ៊ើឈៀ ថូវធឹង"
            ),
            khmer = PhraseTranslation(
                text = "ខ្ញុំមិនសូវស្រួលខ្លួនទេ ខ្ញុំក្តៅខ្លួន និងឈឺក្បាល។",
                romanizedOrPinyin = "Knhom min sov sruol khluon te, knhom kdav khluon ning chheu kbal."
            )
        ),
        ConversationLine(
            id = "hl_2",
            categoryId = "health",
            speakerRoleKm = "ទិញថ្នាំ",
            speakerRoleEn = "At Pharmacy",
            english = PhraseTranslation(
                text = "Where is the nearest pharmacy?",
                romanizedOrPinyin = "/weər ɪz ðə ˈnɪərɪst ˈfɑːrməsi/",
                khmerPhonetic = "វែរ អ៊ីស ដឹ នៀរីស្ត ហ្វាម៉ាស៊ី?"
            ),
            chinese = PhraseTranslation(
                text = "最近的药店在哪里？",
                romanizedOrPinyin = "Zuìjìn de yàodiàn zài nǎlǐ?",
                khmerPhonetic = "ជួយជីន តឺ យ៉ាវទាន ចាយ ណាលី?"
            ),
            khmer = PhraseTranslation(
                text = "តើឱសថស្ថានដែលនៅជិតបំផុតនៅឯណា?",
                romanizedOrPinyin = "Tae osothsthan dael nov chhit bamphot nov ena?"
            )
        ),
        ConversationLine(
            id = "hl_3",
            categoryId = "health",
            speakerRoleKm = "របៀបប្រើថ្នាំ",
            speakerRoleEn = "Dosage",
            english = PhraseTranslation(
                text = "Take this medicine twice a day after meals.",
                romanizedOrPinyin = "/teɪk ðɪs ˈmɛdɪsɪn twaɪs ə deɪ ˈæftər miːlz/",
                khmerPhonetic = "ថេក ឌីស ម៉េឌីស៊ីន ថ្វាយស៍ អឺ ដេ អាហ្វធ័រ មីលស៍"
            ),
            chinese = PhraseTranslation(
                text = "这个药每天吃两次，饭后服用。",
                romanizedOrPinyin = "Zhège yào měitiān chī liǎng cì, fànhòu fúyòng.",
                khmerPhonetic = "ជឺកឺ យ៉ាវ ម៉ីធាន ឈឺ លាំង ឈឺ ហ្វានហូវ ហ្វូយុង"
            ),
            khmer = PhraseTranslation(
                text = "លេបថ្នាំនេះមួយថ្ងៃពីរដង បន្ទាប់ពីបាយរួច។",
                romanizedOrPinyin = "Leb thnam nih muoy thngai pir dong, bantoab pi bay ruoch."
            )
        ),
        ConversationLine(
            id = "hl_4",
            categoryId = "health",
            speakerRoleKm = "ជូនពរឆាប់ជា",
            speakerRoleEn = "Get Well",
            english = PhraseTranslation(
                text = "Please get plenty of rest and drink warm water.",
                romanizedOrPinyin = "/pliːz ɡɛt ˈplɛnti ʌv rɛst ænd drɪŋk wɔːrm ˈwɔːtər/",
                khmerPhonetic = "ភ្លីស ហ្គេត ភ្លេនធី អឹវ រ៉េស្ត អ៊ែន ឌ្រីង វ៉ម វ៉ធ័រ"
            ),
            chinese = PhraseTranslation(
                text = "请多休息，多喝温水。",
                romanizedOrPinyin = "Qǐng duō xiūxi, duō hē wēnshuǐ.",
                khmerPhonetic = "ឈីង តួ ស៊ីវស៊ី តួ ហឺ វិនសួយ"
            ),
            khmer = PhraseTranslation(
                text = "សូមសម្រាកឱ្យបានច្រើន និងផឹកទឹកក្តៅឧណ្ហៗ។",
                romanizedOrPinyin = "Soum samrak oy ban chraen ning phik tik kdav onh onh."
            )
        )
    )
)

internal val phoneWifiCategory = ConversationCategory(
    id = "phone_wifi",
    titleKm = "ទូរស័ព្ទ & អ៊ីនធឺណិត",
    titleEn = "Phone & Wi-Fi",
    titleZh = "电话与网络",
    subtitleKm = "សុំលេខកូដ Wi-Fi សាកថ្ម និងទាក់ទងគ្នា",
    iconType = TopicIconType.PHONE_WIFI,
    phrases = listOf(
        ConversationLine(
            id = "pw_1",
            categoryId = "phone_wifi",
            speakerRoleKm = "សុំលេខកូដ Wi-Fi",
            speakerRoleEn = "Wi-Fi Password",
            english = PhraseTranslation(
                text = "Excuse me, what is the Wi-Fi password?",
                romanizedOrPinyin = "/ɪkˈskjuːz miː wɒt ɪz ðə ˈwaɪfaɪ ˈpæswɜːrd/",
                khmerPhonetic = "អ៊ិកស្គ្យូស មី វ៉ាត់ អ៊ីស ដឹ វ៉ាយហ្វាយ ផាសវើដ?"
            ),
            chinese = PhraseTranslation(
                text = "请问，这里的无线网密码是多少？",
                romanizedOrPinyin = "Qǐngwèn, zhèlǐ de Wúxiànwǎng mìmǎ shì duōshao?",
                khmerPhonetic = "ឈីងវិន ជឺលី តឺ វូស៊ានវ៉ាង មីម៉ា ស៊ឺ តួសាវ?"
            ),
            khmer = PhraseTranslation(
                text = "សុំទោស តើលេខសម្ងាត់ Wi-Fi នៅទីនេះគឺអ្វី?",
                romanizedOrPinyin = "Soum toh, tae lek samngat Wi-Fi nov tineh keu avei?"
            )
        ),
        ConversationLine(
            id = "pw_2",
            categoryId = "phone_wifi",
            speakerRoleKm = "សុំខ្ចីឆ្នាំងសាក",
            speakerRoleEn = "Battery Low",
            english = PhraseTranslation(
                text = "My phone battery is low. Can I charge it here?",
                romanizedOrPinyin = "/maɪ foʊn ˈbætəri ɪz loʊ kæn aɪ tʃɑːrdʒ ɪt hɪər/",
                khmerPhonetic = "ម៉ាយ ហ្វូន ប៊ែតធើរី អ៊ីស ឡូ ខែន អាយ ឆាជ អ៊ិត ហៀរ?"
            ),
            chinese = PhraseTranslation(
                text = "我的手机快没电了，可以在这里充电吗？",
                romanizedOrPinyin = "Wǒ de shǒujī kuài méidiàn le, kěyǐ zài zhèlǐ chōngdiàn ma?",
                khmerPhonetic = "វ៉ តឺ សូវជី ខ្វាយ ម៉ីទាន លឺ ខឺអ៊ី ចាយ ជឺលី ឈុងទាន ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "ទូរស័ព្ទខ្ញុំជិតអស់ថ្មហើយ តើខ្ញុំអាចសាកនៅទីនេះបានទេ?",
                romanizedOrPinyin = "Turosap knhom chhit os thmor haey, tae knhom ach sak nov tineh ban te?"
            )
        ),
        ConversationLine(
            id = "pw_3",
            categoryId = "phone_wifi",
            speakerRoleKm = "សុំលេខទូរស័ព្ទ",
            speakerRoleEn = "Contact Info",
            english = PhraseTranslation(
                text = "Could I have your phone number or WeChat?",
                romanizedOrPinyin = "/kʊd aɪ hæv jɔːr foʊn ˈnʌmbər ɔːr ˈwiːtʃæt/",
                khmerPhonetic = "ឃូដ អាយ ហែវ យ័រ ហ្វូន ណាំប័រ អ័រ វីឆាត?"
            ),
            chinese = PhraseTranslation(
                text = "我可以留一下你的电话或微信吗？",
                romanizedOrPinyin = "Wǒ kěyǐ liú yíxià nǐ de diànhuà huò Wēixìn ma?",
                khmerPhonetic = "វ៉ ខឺអ៊ី លីវ អ៊ីស៊ា នី តឺ ទានហ្វា ហួ វីស៊ីន ម៉ា?"
            ),
            khmer = PhraseTranslation(
                text = "តើខ្ញុំអាចសុំលេខទូរស័ព្ទ ឬ WeChat របស់អ្នកបានទេ?",
                romanizedOrPinyin = "Tae knhom ach soum lek turosap reu WeChat robos neak ban te?"
            )
        ),
        ConversationLine(
            id = "pw_4",
            categoryId = "phone_wifi",
            speakerRoleKm = "ការហៅទូរស័ព្ទ",
            speakerRoleEn = "Phone Call",
            english = PhraseTranslation(
                text = "I will call you back in ten minutes.",
                romanizedOrPinyin = "/aɪ wɪl kɔːl juː bæk ɪn tɛn ˈmɪnɪts/",
                khmerPhonetic = "អាយ វីល ខល យូ ប៊ែក អ៊ីន ថេន មីនីតស៍"
            ),
            chinese = PhraseTranslation(
                text = "我十分钟后给你回电话。",
                romanizedOrPinyin = "Wǒ shí fēnzhōng hòu gěi nǐ huí diànhuà.",
                khmerPhonetic = "វ៉ ស៊ឺ ហ្វិនជុង ហូវ កី នី ហួយ ទានហ្វា"
            ),
            khmer = PhraseTranslation(
                text = "ខ្ញុំនឹងទូរស័ព្ទត្រឡប់ទៅអ្នកវិញក្នុងរយៈពេល១០នាទីទៀត។",
                romanizedOrPinyin = "Knhom neng turosap tralob tov neak vinh knong royak pel dob neati tiet."
            )
        )
    )
)

internal val dailyLifeCategory = ConversationCategory(
    id = "daily_life",
    titleKm = "ជីវភាពប្រចាំថ្ងៃ & មិត្តភក្តិ",
    titleEn = "Daily Life & Friends",
    titleZh = "日常生活与朋友",
    subtitleKm = "អាកាសធាតុ ចំណង់ចំណូលចិត្ត និងការណាត់ជួប",
    iconType = TopicIconType.DAILY_LIFE,
    phrases = listOf(
        ConversationLine(
            id = "dl_1",
            categoryId = "daily_life",
            speakerRoleKm = "អាកាសធាតុ",
            speakerRoleEn = "Weather",
            english = PhraseTranslation(
                text = "The weather is really nice and cool today.",
                romanizedOrPinyin = "/ðə ˈwɛðər ɪz ˈriːəli naɪs ænd kuːl təˈdeɪ/",
                khmerPhonetic = "ដឹ វែដឌ័រ អ៊ីស រៀលលី ណាយស៍ អ៊ែន ឃូល ធូដេ"
            ),
            chinese = PhraseTranslation(
                text = "今天天气真好，很凉快。",
                romanizedOrPinyin = "Jīntiān tiānqì zhēn hǎo, hěn liángkuai.",
                khmerPhonetic = "ជីនធាន ធានឈី ជិន ហៅ ហិន លាំងខ្វាយ"
            ),
            khmer = PhraseTranslation(
                text = "ថ្ងៃនេះអាកាសធាតុល្អ និងត្រជាក់ស្រួលខ្លាំងណាស់។",
                romanizedOrPinyin = "Thngai nih akasthat l'or ning tracheak sruol khlang nah."
            )
        ),
        ConversationLine(
            id = "dl_2",
            categoryId = "daily_life",
            speakerRoleKm = "ចុងសប្តាហ៍",
            speakerRoleEn = "Weekend Plans",
            english = PhraseTranslation(
                text = "What are you planning to do this weekend?",
                romanizedOrPinyin = "/wɒt ɑːr juː ˈplænɪŋ tuː duː ðɪs ˈwiːkɛnd/",
                khmerPhonetic = "វ៉ាត់ អារ យូ ផ្លែនីង ធូ ឌូ ឌីស វីកអ៊ែន?"
            ),
            chinese = PhraseTranslation(
                text = "这个周末你打算做什么？",
                romanizedOrPinyin = "Zhège zhōumò nǐ dǎsuàn zuò shénme?",
                khmerPhonetic = "ជឺកឺ ចូវម៉ នី តាសាន់ ជួ ស៊ិនម៉ឺ?"
            ),
            khmer = PhraseTranslation(
                text = "តើចុងសប្តាហ៍នេះអ្នកមានគម្រោងធ្វើអ្វីដែរ?",
                romanizedOrPinyin = "Tae chong sabda nih neak mean komroung thvoe avei dae?"
            )
        ),
        ConversationLine(
            id = "dl_3",
            categoryId = "daily_life",
            speakerRoleKm = "បបួលផឹកកាហ្វេ",
            speakerRoleEn = "Coffee Invite",
            english = PhraseTranslation(
                text = "Let's grab a cup of coffee together!",
                romanizedOrPinyin = "/lɛts ɡræb ə kʌp ʌv ˈkɒfi təˈɡɛðər/",
                khmerPhonetic = "ឡេតស៍ ហ្គ្រែប អឺ ខាប់ អឹវ ខហ្វហ្វី ធូហ្គេដឌ័រ!"
            ),
            chinese = PhraseTranslation(
                text = "我们一起去喝杯咖啡吧！",
                romanizedOrPinyin = "Wǒmen yìqǐ qù hē bēi kāfēi ba!",
                khmerPhonetic = "វ៉មិន អ៊ីឈី ឈី ហឺ ប៉ី ខាហ្វី ប៉ា!"
            ),
            khmer = PhraseTranslation(
                text = "តោះយើងទៅញ៉ាំកាហ្វេមួយកែវជាមួយគ្នា!",
                romanizedOrPinyin = "Toh yoeng tov nham kafe muoy kaev cheamuoy knea!"
            )
        ),
        ConversationLine(
            id = "dl_4",
            categoryId = "daily_life",
            speakerRoleKm = "រៀនភាសា",
            speakerRoleEn = "Learning Languages",
            english = PhraseTranslation(
                text = "I am practicing speaking English, Chinese, and Khmer every day.",
                romanizedOrPinyin = "/aɪ æm ˈpræktɪsɪŋ ˈspiːkɪŋ ˈɪŋɡlɪʃ tʃaɪˈniːz ænd kəˈmɛər ˈɛvri deɪ/",
                khmerPhonetic = "អាយ អ៊ែម ប្រ៊ែកធីស៊ីង ស្ពីគីង អ៊ិងហ្គ្លីស ឆាយនីស អ៊ែន ខ្មែរ អេវរី ដេ"
            ),
            chinese = PhraseTranslation(
                text = "我每天都在练习说英语、中文和柬埔寨语。",
                romanizedOrPinyin = "Wǒ měitiān dōu zài liànxí shuō Yīngyǔ, Zhōngwén hé Jiǎnpǔzhàiyǔ.",
                khmerPhonetic = "វ៉ ម៉ីធាន តូវ ចាយ លានស៊ី សួ អ៊ីងយី ជុងវិន ហឺ ជានភូចាយយី"
            ),
            khmer = PhraseTranslation(
                text = "ខ្ញុំហាត់និយាយភាសាអង់គ្លេស ចិន និងខ្មែររៀងរាល់ថ្ងៃ។",
                romanizedOrPinyin = "Knhom hat niyeay pheasa Angkles, Chen ning Khmer riengroal thngai."
            )
        )
    )
)
