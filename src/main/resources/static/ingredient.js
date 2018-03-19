$("#ingredient").each("/api/ingredientstock", function(data){
    $("#ingredient").text(data);
});