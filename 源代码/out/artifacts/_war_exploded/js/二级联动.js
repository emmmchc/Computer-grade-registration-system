// 声明数据
var datas = [{
    'signLevel': '计算机等级一级',
    'subjects': ['计算机基础及WPS Office应用(14)', '计算机基础及MS Office应用(15)', '计算机基础及Photoshop应用(16)', '网络安全素质教育(17)']
},
    {
        'signLevel': '计算机等级二级',
        'subjects': ['C语言程序设计(24)', 'VB语言程序设计(26)', 'Java语言程序设计(28)', 'Access数据库程序设计(29)',
            'C++语言程序设计(61)', 'MySQL数据库程序设计(63)', 'Web程序设计(64)', 'MS Office高级应用(65)', 'Python语言程序设计']
    },
    {
        'signLevel': '计算机等级三级',
        'subjects': ['网络技术(35)', '数据库技术(36)', '信息安全技术(38)', '嵌入式系统开发技术(39)']
    },
    {
        'signLevel': '计算机等级四级',
        'subjects': ['网络工程师(41)', '数据库工程师(42)', '信息安全工程师(44)', '嵌入式系统开发工程师(45)']
    }
]
// 当页面加载完毕，等级信息显示在页面中
var signLevelElement = document.getElementById('signLevel')
// 遍历数据 并将每一个signLevel添加
for (var i = 0; i < datas.length; i++) {
    var data = datas[i]
    var signLevelValue = data.signLevel

    var optionElement = document.createElement('option')
    optionElement.textContent = signLevelValue
    optionElement.setAttribute('value', signLevelValue)

    signLevelElement.appendChild(optionElement)
}
signLevelElement.onchange = function () {
    // 先清空科目
    var signSubjectElement = document.getElementById('signSubject')
    var signSubjectOptionElements = signSubjectElement.getElementsByTagName('option')
    for (var y = 1; y < signSubjectOptionElements.length; y++) {
        signSubjectElement.removeChild(signSubjectOptionElements[y])
        y--
    }
    // 获取用户点击的等级名
    var signLevelInfo = signLevelElement.value
    for (var j = 0; j < datas.length; j++) {
        // 取到每一个数据
        var data = datas[j]
        // 取到数据对应的等级
        console.log(data)
        var signLevelData = data.signLevel
        // 判断用户选择的哪个等级
        if (signLevelInfo === signLevelData) {
            var signSubjectDatas = data.subjects
            for (var x = 0; x < signSubjectDatas.length; x++) {
                var signSubjectData = signSubjectDatas[x]
                var optionELement = document.createElement("option")
                optionELement.textContent = signSubjectData
                optionELement.setAttribute("value", signSubjectData)
                signSubjectElement.appendChild(optionELement)
            }
        }

    }
}