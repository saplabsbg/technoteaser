# SAP Техноблъсканица 2020

{::nomarkdown}

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
<input type="checkbox" id=week1Toggle>
<label for=week1Toggle class="week">
<h2 id=week1>Седмица №2 <span></span></h2>
</label>
<div>
<h3 id="week2,question1">Очаквайте скоро</h3>

</div>


<script>
function hashChange() {
	if (window.location.hash) {
		var hashID = window.location.hash.substr(1);
	        var hashArr = hashID.split(",");
	        for (i in hashArr) {
				var obj = document.getElementById(hashArr[i] + (i==0 ? "Toggle" : ""));
				if (obj) {obj.checked = true;
			}
		}
	}
}
window.onhashchange = hashChange;
hashChange();
</script>
<br>
<div class="footer">
<a href="https://www.sap.com/about/careers/who-we-are/locations/sap-labs-bulgaria.html" target="_blank"><p class="footer-element">Виж повече за развойния център на SAP в София</p></a><a href="https://www.sap.com/about/careers/who-we-are/locations/sap-labs-bulgaria.html" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/sap_logo.png" width="40" height="20"></a> <a href="https://www.facebook.com/saplabsbg" target="_blank"><p class="footer-element">Харесай страницата ни във Facebook</p></a><a href="https://www.facebook.com/saplabsbg" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/fb_logo.png" width="30" height="20"></a> <a href="https://jobs.sap.com/search/?q=&locationsearch=bulgaria" target="_blank"><p class="footer-element">Разгледай отворените позиции при нас</p></a><a href="https://jobs.sap.com/search/?q=&locationsearch=bulgaria" target="_blank"><img class="footer-image" src="https://saplabsbg.github.io/technoteaser/docs/images/network.png" width="25" height="25"></a>
</div>

{:/}
