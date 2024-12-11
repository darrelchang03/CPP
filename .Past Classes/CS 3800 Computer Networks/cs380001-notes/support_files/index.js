function toggle_solution( id ) {
    var item = document.getElementById( id );

    if ( item.style.display == "none" ) {
	item.style.display = "";
    } else {
	item.style.display = "none";
    }
}
