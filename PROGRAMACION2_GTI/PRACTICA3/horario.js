var horario = {
    lunes:  {
        fisica: "8:30",
        matematicas: "9:30",
        ingles:"10:30"
    },
    martes:  {
        programacion: "8:30",
        matematicas: "9:30"
    },
    miercoles:  {
        ingles: "8:30",
        fisica:"10:30"
    },
    jueves:  {
        fisica: "8:30",
        matematicas: "9:30",
        ingles:"10:30"
    },
    viernes:  {
        programacion: "8:30",
        matematicas: "9:30"
    }

   }

   var horario_json = JSON.stringify(horario)
   //console.log(horario_json)

   function diasYhoras(obj, asignatura){
        var res = []
        for (const key in obj){
            
            if (obj[key].hasOwnProperty(asignatura)){
                //console.log(obj[key][asignatura])
                res.push(key + " " + obj[key][asignatura])
            }
            
        }

        return res;
   }
   console.log(diasYhoras(horario, "programacion"))