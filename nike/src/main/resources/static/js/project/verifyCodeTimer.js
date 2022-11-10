
const timeArea = document.getElementById('time');
let date = 60;

function getTime() {
    date -= 1
    timeArea.innerText = date;

	if (date == -1) {
		clearInterval(interval);
		timeArea.innerText = '시간만료';
	}
}

getTime();
let interval = setInterval(getTime, 1000)

	
	
