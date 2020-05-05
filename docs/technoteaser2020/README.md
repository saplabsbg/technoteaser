# SAP Техноблъсканица 2020

{::nomarkdown}
<div style="display:none"><img src="https://winwithsap.hana.ondemand.com/services/web/TechQuiz/user/images/sharePicture.png"></div>
<link rel="stylesheet" href="../styles/technoteaser.css">
<link rel="stylesheet" href="../styles/footer.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/latest.js?config=TeX-MML-AM_CHTML' async></script>

<input type="checkbox" id=week1Toggle>
<label for=week1Toggle class="week">
<h2 id=week1>Седмица №1 <span></span></h2>
</label>	
<div>
<h3 id="week1,question1">Най-доброто лекарство</h3>
<p>При проучвания на лечението на рядко заболяване са направени независими едно от друго изпитания на 2 лекарства (лекарство А и лекарство Б).
Всеки доброволец е трябвало да взема едно от лекарствата в продължение на една седмица, за да се установи дали то е ефикасно, или не.<br>Проучванията продължили 2 седмици.
През първата седмица лекарство А е било ефикасно и е излекувало 63 души от общо 90 доброволци (което прави 70% от участвалите). Лекарство Б е било ефикасно при 8 от общо 10 доброволци (80% от участвалите).
През втората седмица лекарство А е било ефикасно при 4 от 10 доброволци (или 40% от участвалите), а лекарство Б е било ефикасно при 45 от 90 доброволци (или 50% от участвалите).

<table style="border-collapse: collapse; margin-top: 10px; margin-bottom: 10px; font-weight: bold; ">
	<tr style="background-color: LightGray;">
		<td style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">Седмица</td><td align=center style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">Лекарство A</td><td align=center style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">Лекарство Б</td>
	</tr>
	<tr>
		<td align=center style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">Седмица 1</td><td align=center style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">\( \dfrac{63}{90}=70 \% \)</td><td align=center style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">\( \dfrac{8}{10}=80 \% \)</td>
	</tr>
	<tr>
		<td align=center style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">Седмица 2</td><td align=center style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">\( \dfrac{4}{10}=40 \% \)</td><td align=center style="padding-left: 5px; padding-right: 5px; padding-top: 5px; padding-bottom: 5px;">\( \dfrac{45}{90}=50 \% \)</td>
	</tr>
</table>

Кое лекарство е по-ефикасно?

<ul class="answersWithRadio">
	<li> Лекарство А е по-ефикасно</li>
	<li> Лекарство Б е по-ефикасно</li>
	<li> Двете лекарства са еднакво добри</li>
</ul>
</p>
<div>
	<input type="checkbox" id=solution11><label class="explanationbutton" for=solution11><span>Обяснение</span></label>
	<div class="explanation">
Гледайки само процентите, на пръв поглед изглежда, че лекарство А е по-неефикасно от лекарство Б (70% и 40% спрямо 80% и 50%).<br>
Въпреки това, една реална проверка на данните изисква пресмятане на крайния процент положително повлияли се хора спрямо всички участвали в изпитанията на конкретното лекарство. В случая доброволците при проучванията и на двете лекарства са точно 100 и е достатъчно да проверим кое лекарство е помогнало на повече (като брой) хора. Лекарство А е помогнало на 63 + 4 = 67 човека (или 67% от всички участвали), а лекарство Б е помогнало на 8 + 45 = 53 човека (или 53% от участвалите), <b>което прави лекарство А по-ефикасно</b>.<br><br>
Защо не можем да вземем средното аритметично на процентните резултати от двете седмици, например за лекарство А (70+40)/2=55%, а за лекарство Б (80+50)/2=65% ?<br>
Причината е във факта, че резултатите от двете седмици имат различна тежест, която зависи от броя доброволци, участвали през тази седмица.
<hr>
Този противоречив и дори заблуждаващ начин на представяне на данните е добре познат в статистиката под името <a href="https://en.wikipedia.org/wiki/Simpson%27s_paradox" target=_blank> Парадокс на Симпсън</a>. Известни са и немалко примери от реалния живот, като например добилият популярност през далечната 1973 г. случай на несъществуваща <a href="https://medium.com/@dexter.shawn/how-uc-berkeley-almost-got-sued-because-of-lying-data-aaa5d641f571" target=_blank> полова дискриминация в Калифорнийския университет, Бъркли</a>, провокиран от недобре интерпретирана информация.<br>

	</div> 
</div>
<h3 id="week1,question2">Здрависване с 9 човека</h3>
<p>На първата мениджърска среща след COVID-19 пандемията присъстват на място в стаята 27 човека. <br>
Възможно ли е всеки в стаята да се здрависа с точно 9 човека?<br>
Разбира се, други хора не участват <img src="https://winwithsap.hana.ondemand.com/services/js/TechQuiz/DocumentService/GetDocument.js?id=XM8dNAdgLdQLXr82FT-8KNvS3JdX4Sg3XOnI5C9bj64" width="20px" alt="Усмивка" title="Усмивка">, закъснели няма <img src="https://winwithsap.hana.ondemand.com/services/js/TechQuiz/DocumentService/GetDocument.js?id=MgD-x1EIDmjmllRROG9xvGp9I34YL-vXULekz3nmBe4" width="20px" alt="Онемял" title="Онемял"> и всички са все още в добро психично здраве, т.е. никой не се здрависва сам със себе си <img src="https://winwithsap.hana.ondemand.com/services/js/TechQuiz/DocumentService/GetDocument.js?id=hCbLs0jTqHI9jYS92iQ7u1lSkHzoztPJEyuXGFiuVA8" width="20px" alt="Изчервяване" title="Изчервяване"></p>
<div>
	<input type="checkbox" id=solution12><label class="explanationbutton" for=solution12><span>Обяснение</span></label>
	<div class="explanation">
Нека предположим, че всеки в стаята се е здрависал с 9 човека и се опитаме да преброим общия брой здрависвания. В едно здрависване участват двама човека, т.е. здрависванията са равни на \( 27*9/2 = 121.5 \), което не е цяло число, откъдето следва, че предположението ни е грешно. Следователно <b>не е възможно в стая с 27 човека всеки да се е здрависал с 9 човека.</b>
	</div> 
</div>

<h3 id="week1,question3">Здрависване с х човека</h3>
<p>Все още обсъждаме мениджърската среща <img src="https://winwithsap.hana.ondemand.com/services/js/TechQuiz/DocumentService/GetDocument.js?id=FHKYiDwH8gHO-gAYwsykDJPznhss7NBYoMCgWl6MPuc" width="20px" alt="Изчервяване" title="Изчервяване">!<br>
В стаята все още има 27 човека.<br>
Ако всеки се е здрависал с еднакъв брой хора, колко най-много може да е той, ако знаем, че не се е здрависал всеки с всеки?</p>
<div>
	<input type="checkbox" id=solution13><label class="explanationbutton" for=solution13><span>Обяснение</span></label>
	<div class="explanation">
От решението на предишната задача вече знаем, че в стаята всеки може да се здрависа с четен (еднакъв) брой хора. Ако всеки се здрависа с 26 човека, това ще означава здрависване всеки с всеки. Следващата възможност е всеки да се здрависа с 24 човека (всички останали без двама). За да проверим, че това е възможно, нека помислим за съответстващо правило за здрависване. Понеже здрависванията са много, всъщност, ще бъде по-лесно да помислим за правило, по което двама души не се здрависват.<br>
Ако подредим хората в кръг, тогава всеки ще има по двама съседи (отляво и отдясно по един) и това би било удобно условие за не-здрависване.<br>
Ако обозначим мениджърите в стаята с m<sub>1</sub>, m<sub>2</sub>, ... , m<sub>27</sub>, чисто математически това правило можем да запишем като:
<ul>
    	<li>m<sub>1</sub> не се здрависва с m<sub>27</sub> и m<sub>2</sub></li>
    	<li>m<sub>i</sub> не се здрависва с m<sub>i-1</sub> и m<sub>i+1</sub>, за i ∈ (1, 27)</li>
    	<li>m<sub>27</sub> не се здрависва с m<sub>26</sub> и m<sub>1</sub></li>
</ul>
Отговор: <b>всеки може да се е здрависал най-много с 24 човека.</b>
	</div> 
</div>
</div>
<!-- end of week 1-->
<input type="checkbox" id=week2Toggle>
<label for=week2Toggle class="week">
<h2 id=week2>Седмица №2 <span></span></h2>
</label>
<div>
<h3 id="week2,question1">Тенис на маса</h3>
<p>Асен, Борис и Влади играли тенис на маса. Във всяка игра участвали двама от тях, а третият си почивал. В следващата игра участвали победителят от текущата игра и почивалият си. След като приключили с игрите се оказало, че Асен е играл в 8 игри, Борис - в 11, а Влади - в 15.<br>Кой е загубил четвъртата игра?</p>
<div>
	<input type="checkbox" id=solution21><label class="explanationbutton" for=solution21><span>Обяснение</span></label>
	<div class="explanation">
От информацията, с която разполагаме, можем да пресметнем общо колко игри са били изиграни. Тъй като във всяка игра участват по двама, броят на игрите е \( (8+11+15)/2 = 17 \).<br>
Ако играч участва в първата игра и губи във всяка своя игра, ще вземе участие в нечетните игри (1,3,5,7,9,11,13,15,17), т.е. в 9 игри.<br>
Ако играч участва във втората игра и губи във всяка своя игра, ще вземе участие в четните игри (2,4,6,8,10,12,14,16), т.е. в 8 игри.<br>
Tъй като участие в 8 игри е теоретичният минимум, то можем да сме сигурни, че Асен е взел участие във втората (и всички четни) игри и е загубил във всички тях, което означава и че <b>Асен е загубил четвъртата игра</b>.
	</div>
</div>
<h3 id="week2,question2">Наследството</h3>
<p>Баща завещал парите си на своите деца по следното правило:<br>
<ol>
	<li>Най-голямото дете получава 1000 лв. и една десета от останалите пари;</li>
	<li>Второто по големина дете (ако го има), получава 2000 лв. и една десета от останалите към този момент пари;</li>
	<li>Третото по големина дете (ако го има), получава 3000 лв. и една десета от новия остатък;</li>
	<li style="list-style-type: none;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;... </li>
	<li style="list-style-type: none;"> n-тото по големина дете (ако го има), получава n*1000 лв. и една десета от останалите към този момент пари.</li>
</ol>
Оказало се, че парите били раздадени без остатък и всяко дете получило една и съща сума пари.<br>
Колко най-много на брой деца е имал бащата?</p>
<div>
	<input type="checkbox" id=solution22><label class="explanationbutton" for=solution22><span>Обяснение</span></label>
	<div class="explanation">
Задачата има едно тривиално решение, когато бащата има 1 дете и 1000 лв., които му дава по така дефинираното правило.<br>
Как проверяваме за други решения?<br>
Нека бащата е имал в началото \( x \) лв. и повече от едно дете.<br>
Тогава първото дете ще получи \( а_1=1000 + \dfrac{1}{10}(x-1000) \) лева,<br>
а второто дете ще получи \( а_2 = 2000 + \dfrac{1}{10}(x-2000-а_1) \) лева.<br>
Понеже \( а_1 = а_2 \) , получаваме следното уравнение:<br>
\( 1000 + \dfrac{1}{10}(x-1000) =  2000 + \dfrac{1}{10}(x-2000 - (1000 + \dfrac{1}{10}(x-1000))) \iff \)<br>
\( x-1000 =  10000 + x-2000 - 1000 - \dfrac{1}{10}(x-1000) \iff \)<br> 
\( \dfrac{1}{10}(x-1000) = 8000 \iff \)<br> 
\( x-1000 = 80000 \iff \)<br> 
\( x = 81000 \)<br> 
Тъй като така съставеното уравнение ни гарантира само факта, че първото и второто по възраст деца получават една и съща сума пари, трябва да проверим какво биха получили останалите:
<ol>
	<li>Първото дете получава \( 1000 + \dfrac{1}{10}(81000-1000) = 1000+8000=9000\) лв., като остават 72000 лв.</li>
	<li>Второто дете получава \( 2000 + \dfrac{1}{10}(72000-2000) = 2000+7000=9000\) лв., като остават 63000 лв.</li>
	<li>Третото дете получава \( 3000 + \dfrac{1}{10}(63000-3000) = 3000+6000=9000\) лв., като остават 54000 лв.</li>
	<li>Четвъртото дете получава \( 4000 + \dfrac{1}{10}(54000-4000) = 4000+5000=9000\) лв., като остават 45000 лв.</li>
	<li>Петото дете получава \( 5000 + \dfrac{1}{10}(45000-5000) = 5000+4000=9000\) лв., като остават 36000 лв.</li>
	<li>Шестото дете получава \( 6000 + \dfrac{1}{10}(36000-6000) = 6000+3000=9000\) лв., като остават 27000 лв.</li>
	<li>Седмото дете получава \( 7000 + \dfrac{1}{10}(27000-7000) = 7000+2000=9000\) лв., като остават 18000 лв.</li>
	<li>Осмото дете получава \( 8000 + \dfrac{1}{10}(18000-8000) = 8000+1000=9000\) лв., като остават 9000 лв.</li>
	<li>Деветото дете получава \( 9000 + \dfrac{1}{10}(9000-9000) = 9000+0=9000\) лв., като не остават повече пари.</li>
</ol>
Следователно <b>бащата е имал най-много 9 деца.</b>
	</div>
</div>
<h3 id="week2,question3">4 камъка и везна</h3> 
<p>Разполагаме с 4 камъка с различен цвят. Знаем, че един от тях тежи 1 грам, един тежи 2 грама, един тежи 3 грама и един тежи 4 грама, но не знаем конкретно кой камък колко тежи. Разполагаме и с везна, която показва от коя страна сме поставили по-голяма тежест или че от двете страни сме поставили едно и също тегло, но не и колко конкретно е теглото на някоя от страните.<img width=150px src="https://winwithsap.hana.ondemand.com/services/js/TechQuiz/DocumentService/GetDocument.js?id=ooyehJUtILEihlXxb3KC2H_G7t5SWodhbEiBhrAb_iM" style="float: right;"> Можем да поставяме прозволен брой камъни на всяка страна на везната.<br>
С колко най-малко претегляния можем да определим теглото на всеки камък (вкл. при най-лошия за нас сценарий, т.е. без да разчитаме на късмет)?</p>
<div>
	<input type="checkbox" id=solution23><label class="explanationbutton" for=solution23><span>Обяснение</span></label>
	<div class="explanation">
Нека обозначим камъните с <font color="darkred">A</font>, <font color="darkred">B</font>, <font color="darkred">C</font> и <font color="darkred">D</font>.Всеки от тях може да участва в точно 3 двойки. Например за камъка <font color="darkred">A</font> това са (<font color="darkred">A</font>, <font color="darkred">B</font>), (<font color="darkred">A</font>, <font color="darkred">C</font>) и (<font color="darkred">A</font>, <font color="darkred">D</font>). На всяка двойка камъни можем да съпоставим останалите два камъка:
<ul>
	<li>(<font color="darkred">A</font>, <font color="darkred">B</font>)  -  (<font color="darkred">C</font>, <font color="darkred">D</font>)</li>
	<li>(<font color="darkred">A</font>, <font color="darkred">C</font>)  -  (<font color="darkred">B</font>, <font color="darkred">D</font>)</li>
	<li>(<font color="darkred">A</font>, <font color="darkred">D</font>)  -  (<font color="darkred">B</font>, <font color="darkred">C</font>)</li>
</ul>
Ако това са три последователни претегляния, след тях ще сме в състояние да кажем кой е най-тежкият камък (с тегло 4 грама) и кой е най-лекият (с тегло 1 грам), понеже:<br>
- Везната ще покаже равно тегло само при едно от тези претегляния и това е случаят, когато от двете страни има тегло от 5 грама (2 + 3 = 1 + 4);<br>
- Най-тежкият камък ще бъде винаги от по-тежката страна в останалите 2 претегляния, с което го определяме еднозначно;<br>
- Най-лекият камък ще бъде винаги от по-леката страна в останалите 2 претегляния, с което също го определяме еднозначно.<br>
Така с четвърто претегляне на останалите два камъка ще определим кой от тях е по-тежък (и съответно тежи 3 грама) и кой по-лек (и е 2 грама).<br><br>

Можем ли да решим задачата с по-малко на брой претегляния?<br>
Всяко претегляне има 3 възможни резултата (лявата страна е по-тежка, равна или по-лека на дясната). Това означава, че едно претегляне ни дава най-много \( \log _{2} 3 \) бита информация.<br>
Имаме \( 4!=24 \) възможни конфигурации за камъните, т.е.  \( \log _{2} 24 \) бита възможости.<br>
Ако имаме нужда от \( n \) претегляния, с които можем да определим еднозначно теглата на камъните, то със сигурност  \( n * \log _{2} 3  \ge \log _{2} 24 \iff \)  \( n  \ge \dfrac{\log _{2} 24}{ \log _{2} 3 } \iff \) \( n  \ge \log _{3} 24 \iff \) \( n  \ge 2.89 \implies \) \( n  \ge 3 \)<br>
Тогава можем ли да решим задачата с 3 претегляния?<br>
Отговорът е отрицателен и за да го покажем, ще трябва да разгледаме по-подробно възможните конфигурации за първо претегляне, които са:<br>
- 1:1 (един камък спрямо един камък).<br>В този случай везната не може да бъде балансирана, а от двата възможни резултата от измерването получаваме точно 1 бит информация. Тъй като теоретичният максимум от останалите 2 измервания е \( 2\log_2 3 \), а \( 1 + 2\log_2 3 \lt log_2 24 \), то нямаме шанс да определим теглото на камъните в общия случай.<br>
- 1:2 (един камък спрямо два камъка).<br>
Имаме 4 конфигурации, при които везната ще е балансирана: (1 + 2 = 3), (2 + 1 = 3), (1 + 3 = 4) и (3 + 1 = 4)<br>
Останалите 20 конфигурации се разпределят за случаите, при които везната няма да е балансирана. Дори и те да са разпределени по равно (което по принцип не е така), т.е. 10 за случая двойката камъни да е по-лека от камъка от другата страна и 10 за случая двойката камъни да е от по-тежката страна, с останалите 2 премервания можем да разграничим най-много \( 3^2 = 9 \) случая, т.е. те са недостатъчно. <br>
- 1:3 (един камък спрямо три камъка).<br>
Едно такова премерване няма да ни даде никаква нова информация, тъй като 3 камъка са винаги по-тежки от един.<br>
- 2:2 (два камъка спрямо два камъка).<br>
Това измерване е единственото, което разделя 24-те възможни конфигурации на камъните на равен на брой подслучаи (8-8-8), т.е. получаваме \( \log _{2} 3 \) бита информация. Това означава, че с оставащите 2 измервания ще трябва да определим еднозначно в коя от оставащите 8 възможности се намираме, което изглежда теоретично възможно. Оказва се, обаче, че нямаме следващо измерване, което да ни даде \(\log _{2} 3 \) бита информация. Например един възможен изход от първото измерване е везната да е балансирана. Повторно премерване от вида (2:2) с друга конфигурация на камъните със сигурност не може да балансира везната. Това е валидно и за премерване от вида (1:1) и (1:3), а премерването (1:2) не разпределя равномерно оставащите случаи (което е необходимо условие за \(\log _{2} 3 \) бита нова информация). Случаят (1:2), когато двата камъка са избирани от различни страни на везната (спрямо първото претегляне), разделя възможните конфигурации на камъните на (2-5-1), което в най-лошия за нас случай оставя 5 възможности, т.е. получаваме под 1 бит информация. Измерване от вида (1:2), когато оставяме двата камъка от едната страна на везната (от първото претегляне), отново никога не балансира везната. Тъй като второто измерване ни дава най-много 1 бит нова информация (т.е. от 8 случая остават поне 4), то третото измерване със сигурност е недостатъчно, а от гледна точка на информацията попадаме в неравенството \( \log_2 3 + 1 +\log_2 3 \lt \log_2 24 \).<br><br>

Въпреки че на пръв поглед непровереният теоретичен минимум ни навежда към 3 претегляния, липсата на практически алгоритъм (поредица от измервания, които да дават всеки път \(\log _{2} 3 \) бита нова информация) води до необходимост от 4 претегляния за решение на задачата в общия случай.<br>
<b>Отговор: 4 претегляния</b>
<hr>
 Основите на <a href="https://bg.wikipedia.org/wiki/%D0%A2%D0%B5%D0%BE%D1%80%D0%B8%D1%8F_%D0%BD%D0%B0_%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8F%D1%82%D0%B0" target=_blank>теорията на информацията</a> са положени от <a href="https://bg.wikipedia.org/wiki/%D0%9A%D0%BB%D0%BE%D0%B4_%D0%A8%D0%B0%D0%BD%D1%8A%D0%BD" target=_blank>Клод Шанън </a> (<a href="https://en.wikipedia.org/wiki/Claude_Shannon" target=_blank>Claude Shannon</a>), срещащ се в литература още под името Шенон. В негова чест е кръстена и мерната единица за информация Шенон, която отдавна е отстъпила място на далеч по-популярния бит. 1 <a href="https://en.wikipedia.org/wiki/Shannon_(unit)" target=_blank>Шенон</a> информация = 1 бит информация = информацията, която получаваме от събитие, което се случва с вероятност 50% = ентропията на система, която има 2 възможни и равновероятностни състояния.<br>
 В решението на задачата често се налагаше да работим с \(\log _{2} 3 \) бита информация, която получаваме от събитие с три възможни и равно вероятни изхода. Това количество информация е равно точно на 1 трит (<a href="https://en.wikipedia.org/wiki/Ternary_numeral_system" target=_blank>trit</a>).
	</div>
</div>
</div>
<!-- end of week 2-->
<input type="checkbox" id=week3Toggle>
<label for=week3Toggle class="week">
<h2 id=week3>Седмица №3 <span></span></h2>
</label>	
<div>
<h3 id="week3,question1">Счупеният асансьор</h3>
<p>Асансьор в 100-етажна сграда се е развалил и работят само два аварийни бутона. Единият бутон е син, с който асаньорът се изкачва 7 етажа, при условие че асансьорът се намира под 94-тия етаж. Другият бутон е жълт, с който асансьорът слиза 9 етажа, при условие че асансьорът е над 9-тия етаж.<br>
Ако асаньорът е на 1-вия етаж, с колко най-малко придвижвания (натискане на авариен бутон) можем да го закараме на 72-рия етаж.</p>
<div>
	<input type="checkbox" id=solution31><label class="explanationbutton" for=solution31><span>Обяснение</span></label>
	<div class="explanation">
Нека предположим, че трябва да натиснем общо \( x \) пъти синия и \( y \) пъти жълтия бутон. Тогава:<br>
\( 1 + 7x -9y = 72 \implies 7x=9y+71 \iff x=y+10+ \dfrac{2y+1}{7} \)<br>
Тъй като \( x \) и \( y \) са цели положителни числа (или 0), то  \( y = 3,10,17 \dots , y \equiv 3 ~( \text{mod } 7 ) \)<br>
При \( y = 3 \) получаваме \( x = 14 \) или общо 17 придвижвания.<br>
При \( y = 10 \) получаваме \( x = 23 \) или общо 33 придвижвания.<br>
Сравнително лесно се забелязва, че с всяка следваща възможна стойност за  \( y \) крайният брой придвижвания само се увеличава. <br>
Възможно решение ли е \( y = 3 \) и \( x = 14 \)?
Макар и не всеки път да са възможни и двата бутона, сигурни сме, че поне един от тях е възможен, например:<br>
\(1 + 10*7 = 71, 71 - 3*9=44, 44 + 4*7 = 72\)<br>
<b>Отговор: 17</b> <br>
Задачата е достатъчно лесна и за решение чрез програма, която генерира и проверява последователно всички възможни двойки  \( x \) и \( y \)  (отново естествени числа или 0), като стандартният алгоритъм за това е:
<ol>
<li>Генерираме последователно всяко естествено число  (\( sum \))  </li>
<li>За всяко \( sum \) генерираме всички възможни двойки \( x \) и \( y \), такива че \( x + y = sum \)</li>
<li>Проверяваме всяка получена двойка \( x \) и \( y \) дали удовлетворява уравнението \( 1 + 7x -9y = 72 \)</li>
</ol>
Тъй като ние генерираме сумата на \( x \) и \( y \)  последователно, можем да сме сигурни, че когато уравнението е изпълнено за пръв път, сме намерили най-малката възможна сума.
{:/}

```java
IntStream.iterate(0, i -> i + 1).filter(sum -> {
	return IntStream.rangeClosed(0, sum).filter(x -> {
		int y = sum - x;
		if (1 + 7*x - 9*y == 72) {
			System.out.println(sum + ": x=" + x + ", y=" + y);
			return true;
		} else {
			return false;
		}
	}).findFirst().isPresent();
}).findFirst();
```
{::nomarkdown}
<div style="background: #000;border: 1px solid #ccc; color: white; display: block;padding: 5px;width: 100%;font-size: 90%;">17: x=14, y=3
</div>
	</div>
</div>
<h3 id="week3,question2">Рекурсия</h3>
<p> \( f(n) = \begin{cases} n-3 ~~~\text{ , при } n\gt2020 \\ f^n(4n) \text{ , в противен случай }\end{cases} \)
<br>където<br>
\( f^1(n) = f(n) \) <br> \( f^2(n) = f(f(n)) \) <br> <!-- \( f^3(n) = f(f(f(n))) \) <br> --> \( \cdots \) <br> \( f^p(n) = \underbrace{f( \dots f(f(}_\text{p пъти} n)) \dots) \)<br>
<nobr>Да се намер \( f(1)=\text{ ?} \)</nobr><br>
Ако \( f(1) \) не е изчислимо, отговорете с английската буква u (от undefined).</p>
<div>
	<input type="checkbox" id=solution32><label class="explanationbutton" for=solution32><span>Обяснение</span></label>
	<div class="explanation">
Първото нещо, с което трябва да се съобразим, е, че \( f^m(f^n(x)) = f^{m+n}(x)  = f^{m+n -1}(f(x)) \) <br> <!-- = f^n(f^m(x))  -->
<br>
<h4>Решението на програмиста:</h4>
Дефиницията на функцията е достатъчно лесна, за да можем да я имплементираме дословно:
{:/}

```java
private int f(int n) {
	if (n > 2020) {
		return n - 3;
	} else {
		int currentResult = f(4*n);
		for(int i = 1; i < n; i++) {
			currentResult = f(currentResult);
		}
		return currentResult;
	}
}
```
Една малко по-оптимална имплементация би била итеративната, например:
```java
int n = 1;
int timesToApply= 1;
while(timesToApply > 0) {
	timesToApply --;
	if (n > 2020) {
		n -= 3;
	} else {
		timesToApply += n;
		n *= 4;
	}
}
System.out.println(n);
```
{::nomarkdown}
<div style="background: #000;border: 1px solid #ccc; color: white; display: block;padding: 5px;width: 100%;font-size: 90%;">2020</div>
<br>
<h4>Решението на математика:</h4>
<big> 
\( f(1) = f^1(4) = f^4(4*4) = f^4(16) \) <br>
\( f^4(16) = f^3(f(16)) = f^3(f^{16}(16*4)) = f^{3+16}(64)\) <br>
\( f^{3+16}(64) = f^{2+16+64}(256) = f^{1+16+64+256}(1024) = f^{16+64+256+1024}(4096) \)<br>
\( f^{16+64+256+1024}(4096) = f^{1360}(2020 + 3*692) = f^{1360-692}(2020) = f^{668}(2020) \)<br>
\( f^{668}(2020) = f^{667+2020}(4*2020) = f^{667+2020}(2020 + 3*2020) = f^{667}(2020) \)<br>
\( f^{667}(2020) = f^{666 + 2020}(4*2020) = f^{666 + 2020}(2020 + 3*2020) = f^{666}(2020) \)<br>
\( \cdots  \)<br>
\( f^{668}(2020) = f^{667}(2020) = \cdots = f^{1}(2020)  \)<br>
\( f^1(2020) = f^{2020}(4*2020) = f^{2019+1}(2020 + 3*2019+3) = f^1(2020+3) = 2020 \)<br>
\( \mathbf{\implies f(1) = 2020} \)<br>
</big>
<br>
За естествени числа функцията може да се дефинира по следния еквивалентен и много по-лесен за изчисление начин:
\( f(n) =  \begin{cases} 2018 ~\text{ , при } n \lt 2020  \text{ и } n \equiv 2 \pmod 3  \\ 2019 ~\text{ , при } n \lt 2020  \text{ и } n \equiv 0 \pmod 3  \\ 2020 ~\text{ , при } n \le 2020  \text{ и } n \equiv 1 \pmod 3  \\  n-3 \text{ , при } n \gt 2020  \end{cases}  \)
	</div>
</div>
<h3 id="week3,question3">Четирите четворки</h3>
<p>Разполагаме с четири четворки: <font color="darkred"><b>4 4 4 4</b></font>, с двуаргументните аритметични операции събиране (<font color="darkred"><b>+</b></font>), изваждане (<font color="darkred"><b>-</b></font>), умножение (<font color="darkred"><b>∗</b></font>) и деление (<font color="darkred"><b>/</b></font>), както и с едноаргументната аритметична операция квадратен корен (<font color="darkred"><b>√</b></font>), приложима както върху числа, така и върху подизрази. Всяка операция можем да ползваме произволен, краен брой пъти. Съседни цифри, между които не поставим операция, участват в израза като многоцифрено число.<br>
Приемаме, че важат стандартните приоритети на операциите (умножението и делението са с по-висок приоритет от събирането и изваждането), операциите са ляво асоциативни (т.е. операции с един и същи приоритет се изпълняват от ляво надясно, например <font color="darkred">4/4/4∗4</font>=1) и не можем да използваме скоби за смяна на така дефинираната последователност на изчисленията.<br>
Като ползваме тези правила, се опитваме да съставим валидни аритметични изрази, които са равни съответно на 1, 2, 3 и т.н.<br>
Примери с валидни изрази:<br>
<ol>
	<li><span style="font-size:small">\( \sqrt{44}/\sqrt{44} = 1\)</span></li>
	<li><span style="font-size:small">\( \sqrt{4/\sqrt{4/\sqrt{4*4}}} = 2 \)</span></li>
	<li style="list-style-type: none;">...</li>
</ol>
Кое е първото (най-малкото) естествено число, за което не можем да съставим валиден аритметичен израз?</p>
<div>
	<input type="checkbox" id=solution33><label class="explanationbutton" for=solution33><span>Обяснение</span></label>
	<div class="explanation">
Примерни аритметични изрази:
<ol>
	<li> \( 44/44  = 1 \)</li>
	<li> \( 4/4 + 4/4 = 2 \)</li>
	<li> \( 4/4+4/\sqrt{4} = 3 \)</li>
	<li> \( \sqrt{4*4+4-4} = 4 \)</li>
	<li> \( \sqrt{4*4}+4/4 = 5 \)</li> 
	<li> \( 4+\sqrt{4-4+4} = 6 \)</li> 
	<li> \( 44/4-4 = 7 \)</li> 
	<li> \( 4+4+4-4 = 8 \)</li>
	<li> \( 4+4+4/4 = 9 \)</li> 
	<li> \( 4+4+4/\sqrt{4} = 10\)</li> 
	<li> \( 44/\sqrt{4*4} = 11\)</li>
	<li> \( 4+4+\sqrt{4*4} = 12\)</li> 
	<li> \( 44/4+\sqrt{4} = 13\)</li> 
	<li> \( 4+4+4+\sqrt{4} = 14 \)</li> 
	<li> \( 44/4+4 = 15 \)</li> 
	<li> \( 4*4*4/4  = 16 \)</li>
	<li> \( 4*4+4/4  = 17 \)</li>
	<li> \( 4*4+4-\sqrt{4} = 18 \) </li> 
	<li style="color:darkred">Не съществува аритметичен израз, равен на 19</li>
</ol>
<b>Имплементационни детайли:</b><br>
Тъй като операцията корен квадратен е едноаргументна, тя може да се ползва произволно много пъти, т.е. не е възможно да генерираме всички възможни аритметични изрази. От друга страна обаче, ние се интересуваме само от аритметични изрази, които връщат като резултат цяло число, и това ни позволява да направим следните ограничения:
<ul>
<li>\( \sqrt{\sqrt{4}}=\sqrt{2} \) e ирационално число и един лесен начин да получим като краен резултат цяло число е да имаме деление или изваждане със същото ирационално число, т.е. получаваме подизрази от вида  \( \sqrt{\sqrt{4}}/\sqrt{\sqrt{4}} = \sqrt{\sqrt{\sqrt{4}}}/\sqrt{\sqrt{\sqrt{4}}} = \dots = 1 \), които обаче са еквивалентни и можем да пропуснем, фокусирайки се само върху изрази и подизрази с минимален брой операции за коренуване. </li>
<li>Три вложени квадратни корена върху един единствен аритметичен подизраз може да доведе до краен резултат цяло число при положение, че не ползваме деление, само в следните случаи: <ul><li>\( \sqrt{\sqrt{\sqrt{4}}}*\sqrt{\sqrt{\sqrt{4*4*4}}}=2 \)</li>  <li>\( \sqrt{\sqrt{\sqrt{4*4}}}*\sqrt{\sqrt{\sqrt{4*4}}}=2 \)</li>   <li>\( \sqrt{\sqrt{\sqrt{4*4*4}}}*\sqrt{\sqrt{\sqrt{4}}}=2 \)</li> <li style="list-style-type: none;">...</li> <li>\( \sqrt{\sqrt{\sqrt{4}}}*\sqrt{\sqrt{\sqrt{4}}}*\sqrt{\sqrt{\sqrt{4}}}*\sqrt{\sqrt{\sqrt{4}}}=2 \)</li></ul>
Тези случаи можем да изпуснем, тъй като аритметичен израз, равен на 2, можем да получим и по друг начин - нещо, което е видно и в примерите към условието.
</li>
<li> 4 и повече вложени квадратни корени върху един единствен подизраз или число не могат да участват в аритметичен израз, който да бъде равен на цяло число, без да попадаме в първия случай.</li>
</ul>
<br>
За да указваме еднозначно аргумента на операцията квадратен корен, ще ползваме записа sqrt(&lt;подизраз&gt;), например sqrt(4).<br>
Използвайки мета-езика на Бекус-Наур (<a href="https://en.wikipedia.org/wiki/Backus%E2%80%93Naur_form" target=_blank>Backus–Naur form</a>), можем да дефинираме (рекурсивно) възможните аритметични изрази, от които се интересуваме, по следния начин: <br>
<style>
.definition { color: black;}
.definition::before {content: "<";}
.definition::after {content: ">";}
.separator {color:black;}
.obsolete {color:grey;}
</style>
<ul>
<li><span class="definition">op</span> ::= + <span class="separator">|</span>  - <span class="separator">|</span>  * <span class="separator">|</span>  / </li>
<li><span class="definition">expr1</span> ::= 4 <span class="separator">|</span>  sqrt(4) <span class="separator">|</span>  sqrt(sqrt(4))</li>
<li><span class="definition">expr2</span> ::= 44 <span class="separator">|</span>  sqrt(44) <span class="separator">|</span>  sqrt(sqrt(44)) <span class="separator">|</span>  <span class="definition">expr1</span> <span class="definition">op</span> <span class="definition">expr1</span> <span class="separator">|</span>  sqrt(<span class="definition">expr1</span> <span class="definition">op</span> <span class="definition">expr1</span>) </li>
<li><span class="definition">expr3</span> ::= 444 <span class="separator">|</span>  <span class="obsolete">sqrt(444)</span> <span class="separator">|</span>  <span class="definition">expr1</span> <span class="definition">op</span> <span class="definition">expr2</span> <span class="separator">|</span>  sqrt(<span class="definition">expr1</span> <span class="definition">op</span> <span class="definition">expr2</span>) <span class="separator">|</span>  <span class="definition">expr2</span> <span class="definition">op</span> <span class="definition">expr1</span> <span class="separator">|</span>  sqrt(<span class="definition">expr2</span> <span class="definition">op</span> <span class="definition">expr1</span>)</li>
<li><span class="definition">expr4</span> ::= 4444 <span class="separator">|</span> <span class="obsolete">sqrt(4444)</span> <span class="separator">|</span>  <span class="definition">expr2</span> <span class="definition">op</span> <span class="definition">expr2</span> <span class="separator">|</span>  sqrt(<span class="definition">expr2</span> <span class="definition">op</span> <span class="definition">expr2</span>) <span class="separator">|</span>  <span class="definition">expr3</span> <span class="definition">op</span> <span class="definition">expr1</span> <span class="separator">|</span>  sqrt(<span class="definition">expr3</span> <span class="definition">op</span> <span class="definition">expr1</span>) <span class="separator">|</span>  <span class="definition">expr1</span> <span class="definition">op</span> <span class="definition">expr3</span> <span class="separator">|</span>  sqrt(<span class="definition">expr1</span> <span class="definition">op</span> <span class="definition">expr3</span>)</li>
</ul>
Някои излишни случаи, които не водят до изрази, равняващи се на цяло число, са добавени за пълнота в сиво.<br>
<a href="https://github.com/saplabsbg/technoteaser/blob/master/src/saptechnoteaser2020/week3/TheFour4s.java" target="_blank">Примерен Java код</a>
<hr>
Задачата с четирите четворки е била поставена за пръв път в края на 19<sup>-ти</sup> век, като бързо става  популярна сред любителите на математиката. Разбира се, съществували са различни интерпретации за това кои операции са основни и позволени. През 30<sup>-те</sup> години на миналия век задачата отново набира популярност. Тогава известният физик Пол Дирак (<a href="https://en.wikipedia.org/wiki/Paul_Dirac" target=_blank>Paul Dirac</a>), който освен физик е бил и голям любител на математическите пъзели, успява да даде елегантно решение за произволно естествено число, като използва в допълнение двуаргументната операция логаритъм. (\( a=b^c \iff \log_{b}a = c \), \( \log_{b}(b^a) = a \))
<ul style="align:left; width: 1px; overflow: visible;">
	<li>$$ \log_{\sqrt{4}/4}(\log_4\sqrt{4}) = \log_{1/2}(\log_4 4^{1/2}) = \log_{1/2}1/2=1$$</li>
	<li>$$ \log_{\sqrt{4}/4}(\log_4\sqrt{\sqrt{4}}) = \log_{1/2}(\log_4 4^{\frac{1}{2}*\frac{1}{2}}) = \log_{1/2}(\log_4 4^{(1/2)^2}) = \log_{1/2}(1/2)^2=2$$</li>
	<li>$$ \log_{\sqrt{4}/4}(\log_4\sqrt{\sqrt{\sqrt{4}}}) = \log_{1/2}(\log_4 4^{(1/2)^3}) = \log_{1/2}(1/2)^3=3$$</li>
	<li style="list-style-type: none;">...</li>
	<li>$$ \log_{\sqrt{4}/4}(\log_4\underbrace{\sqrt{\dots \sqrt{4}}}_\text{n пъти}) = \log_{1/2}(\log_4 4^{(1/2)^n}) = \log_{1/2}(1/2)^n=n$$</li>
</ul>
	</div>
</div>
</div>
<!-- end of week 3-->
<input type="checkbox" id=week4Toggle>
<label for=week4Toggle class="week">
<h2 id=week4>Седмица №4 <span></span></h2>
</label>	
<div>
<h3 id="week4,question1">Числото на Петко</h3>
<p>Петко си намислил едно голямо число, за което твърдял, че:
<ol>
	<li>Числото се дели на 1</li>
	<li>Числото се дели на 2</li>
	<li>Числото се дели на 3</li>
	<li style="list-style-type: none;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;... </li>
	<li value="30">Числото се дели на 30</li>
	<li value="31">Числото се дели на 31</li>
</ol>
В последствие се оказало, че две последователни твърдения са неверни, а всички останали са верни.<br>
Кои са неверните твърдения?</p>
<div>
	<input type="checkbox" id=solution41><label class="explanationbutton" for=solution41><span>Обяснение</span></label>
	<div class="explanation">
		Очаквайте скоро!
	</div>
</div>
<h3 id="week4,question2">Голямата полемика</h3>
<p>Група от 45 ученици обсъждали разпалено решението на една задача. Първоначално 13 от учениците вярвали в правотата на решение и отговор 1, други 15 от учениците - в отговор 2, и останалите 17 - в отговор 3. Задачата била толкова трудна и противоречива, че всеки път, когато двама ученика с различни отговори се срещали да обсъдят решението, те взаимно се убеждавали, че грешат. В резултат на това и двамата започвали да вярват в решението и отговора, в което първоначално никой от тях не вярвал.<br>
Кои от следните твърдения са верни?<br>
Приемаме, че всеки ученик може да промени отговора си произволен брой пъти, дискусиите в групата се провеждат винаги по двама и външни хора не участват.
<ul class="answersWithCheckbox">
	<li>Възможно е след определено време във всеки отговор да вярват един и същи брой ученици.</li>
	<li>Няма как след определено време във всеки отговор да вярват един и същи брой ученици.</li>
	<li>Няма как след определено време един и същи брой ученици да вярват в отговор 1 и отговор 3.</li>
	<li>Възможно е след определено време всеки ученик да вярва, че отговор 1 е верен.</li>
	<li>Възможно е след определено време всеки ученик да вярва, че отговор 2 е верен.</li>
	<li>Възможно е след определено време всеки ученик да вярва, че отговор 3 е верен.</li>
	<li>Няма как след определено време всички ученици да вярват в един и същи отговор, независимо кой е той.</li>
</ul>
</p>
<div>
	<input type="checkbox" id=solution42><label class="explanationbutton" for=solution42><span>Обяснение</span></label>
	<div class="explanation">
		Очаквайте скоро!
	</div>
</div>
<h3 id="week4,question3">Oгърлици</h3>
<p>Колко различни огърлици могат да бъдат направени от 4 жълти, 6 сини и 8 червени мъниста, като ползваме винаги всички налични мъниста?<br>
Две огърлици са различни, когато не можем да получим цветовата наредба на мънистата на едната огърлица чрез завъртане и/или преобръщане на другата огърлицата.<br>
Топчетата мъниста от един цвят са еднакви и неразличими помежду си, т.е. разменяйки местата на две мънистa с еднакъв цвят, няма да променим огърлицата.<br>
Пример: Трите огърлици от снимката са еднакви и трябва да бъдат преброени като една уникална огърлица, а номерирането на мънистата е условно.<br>
Средната огърица получаваме след завъртане на лявата на 180°, а дясната получаваме от средната като я обърнем надясно.
<img style="display:block; max-width: 100%; height: auto; vertical-align: middle; border: 0;" src="https://winwithsap.hana.ondemand.com/services/js/TechQuiz/DocumentService/GetDocument.js?id=u1IlL-QV0lNpsWPI9dfs7flyBfMJk4mYMYWHHhN8Ptc">
</p>
<div>
	<input type="checkbox" id=solution43><label class="explanationbutton" for=solution43><span>Обяснение</span></label>
	<div class="explanation">
		Очаквайте скоро!
	</div>
</div>
</div>
<!-- end of week 3-->

<script>
function hashChange() {
	if (window.location.hash) {
		var hashID = window.location.hash.substr(1);
        var hashArr = hashID.split(",");
        for (i in hashArr) {
			var obj = document.getElementById(hashArr[i] + (i==0 ? "Toggle" : ""));
			if (obj) {obj.checked = true;}
		}
	}
}
window.onhashchange = hashChange;
window.onload = hashChange;
hashChange();
</script>
<br>
<div class="footer">
<a href="https://www.sap.com/about/careers/who-we-are/locations/sap-labs-bulgaria.html" target="_blank"><p class="footer-element">Виж повече за развойния център на SAP в София</p></a><a href="https://www.sap.com/about/careers/who-we-are/locations/sap-labs-bulgaria.html" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/sap_logo.png" width="40" height="20"></a> <a href="https://www.facebook.com/saplabsbg" target="_blank"><p class="footer-element">Харесай страницата ни във Facebook</p></a><a href="https://www.facebook.com/saplabsbg" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/fb_logo.png" width="30" height="20"></a> <a href="https://jobs.sap.com/search/?q=&locationsearch=bulgaria" target="_blank"><p class="footer-element">Разгледай отворените позиции при нас</p></a><a href="https://jobs.sap.com/search/?q=&locationsearch=bulgaria" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/network.png" width="25" height="25"></a>
</div>

{:/}
