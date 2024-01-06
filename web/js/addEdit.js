document.addEventListener('DOMContentLoaded', (event) => {
    // Código para el select de género
    const labelForGender = document.querySelector('label[for="genero"]');
    const selectDiv = document.querySelector('.select');

    labelForGender.addEventListener('click', () => {
        selectDiv.click();
    });

    // Código para los dropdowns
    const dropdowns = document.querySelectorAll('.dropdown');

    dropdowns.forEach((dropdown, index) => {
        const select = dropdown.querySelector('.select');
        const caret = dropdown.querySelector('.caret');
        const menu = dropdown.querySelector('.menu');
        const options = dropdown.querySelectorAll('.menu li');
        const selected = dropdown.querySelector('.selected');

        select.addEventListener('click', () => {
            select.classList.toggle('select-clicked');
            caret.classList.toggle('caret-rotate');
            menu.classList.toggle('menu-open');
        });

        options.forEach((option, index) => {
            option.addEventListener('click', () => {
                selected.innerText = option.innerText;
                select.classList.remove('select-clicked');
                caret.classList.remove('caret-rotate');
                menu.classList.remove('menu-open');
                options.forEach(option => {
                    option.classList.remove('active');
                });
                option.classList.add('active');
            });
        });
    });
});
