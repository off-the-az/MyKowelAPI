<<<<<<< HEAD
const isMobile = {
	Android: function () {
		return navigator.userAgent.match(/Android/i);
	},
	BlackBerry: function () {
		return navigator.userAgent.match(/BlackBerry/i);
	},
	iOS: function () {
		return navigator.userAgent.match(/iPhone|iPad|iPod/i);
	},
	Opera: function () {
		return navigator.userAgent.match(/Opera Mini/i);
	},
	Windows: function () {
		return navigator.userAgent.match(/IEMobile/i);
	},
	any: function () {
		return (
			isMobile.Android() ||
			isMobile.BlackBerry() ||
			isMobile.iOS() ||
			isMobile.Opera() ||
			isMobile.Windows()
		);
	},
};

const menu = () => {
	if (isMobile.any()) {
		document.body.classList.add('page__body--touch');

		const menuArrow = document.querySelectorAll('.menu__arrow');

		menuArrow.forEach((arrow) => {
			arrow.parentElement.setAttribute('href', '#');
			arrow.addEventListener('click', (e) => {
				arrow.parentElement.classList.toggle('menu__item--active');
			});
		});
	} else {
		document.body.classList.add('page__body--pc');
	}

	const header = document.querySelector('.header');
	const iconMenu = document.querySelector('.menu__icon');
	if (iconMenu != null) {
		const menuBody = document.querySelector('.menu__body');
		iconMenu.addEventListener('click', () => {
			menuBody.style.paddingTop = `${header.offsetHeight}px`;
			document.body.classList.toggle('page__body--lock');
			iconMenu.classList.toggle('menu__icon--active');
			menuBody.classList.toggle('menu__body--active');
		});
	}
};
menu();
=======
const isMobile = {
	Android: function () {
		return navigator.userAgent.match(/Android/i);
	},
	BlackBerry: function () {
		return navigator.userAgent.match(/BlackBerry/i);
	},
	iOS: function () {
		return navigator.userAgent.match(/iPhone|iPad|iPod/i);
	},
	Opera: function () {
		return navigator.userAgent.match(/Opera Mini/i);
	},
	Windows: function () {
		return navigator.userAgent.match(/IEMobile/i);
	},
	any: function () {
		return (
			isMobile.Android() ||
			isMobile.BlackBerry() ||
			isMobile.iOS() ||
			isMobile.Opera() ||
			isMobile.Windows()
		);
	},
};

const menu = () => {
	if (isMobile.any()) {
		document.body.classList.add('page__body--touch');

		const menuArrow = document.querySelectorAll('.menu__arrow');

		menuArrow.forEach((arrow) => {
			arrow.parentElement.setAttribute('href', '#');
			arrow.addEventListener('click', (e) => {
				arrow.parentElement.classList.toggle('menu__item--active');
			});
		});
	} else {
		document.body.classList.add('page__body--pc');
	}

	const header = document.querySelector('.header');
	const iconMenu = document.querySelector('.menu__icon');
	if (iconMenu != null) {
		const menuBody = document.querySelector('.menu__body');
		iconMenu.addEventListener('click', () => {
			menuBody.style.paddingTop = `${header.offsetHeight}px`;
			document.body.classList.toggle('page__body--lock');
			iconMenu.classList.toggle('menu__icon--active');
			menuBody.classList.toggle('menu__body--active');
		});
	}
};
menu();
>>>>>>> b11b88f (v. 0.1.11-2)
