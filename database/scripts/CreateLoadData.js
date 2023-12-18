use mydb

db.createCollection('voluntarios')

db.voluntarios.insertMany([{
    "nombreVoluntario": "Juan",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Pérez",
    "telefonoVoluntario": "+56901234567",
    "direccionVoluntario": "Nueva Imperial N° 4261",
    "fechaNacimientoVoluntario": "1990-01-01",
    "disponibilidadVoluntario": "2023-11-20",
    "emailVoluntario": "juan.perez@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.692909,
        -33.444485
      ]
    }
  },
  {
    "nombreVoluntario": "Maria",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      }
    ],
    "apellidoVoluntario": "González",
    "telefonoVoluntario": "+56907654321",
    "direccionVoluntario": "Eliodoro Yañez N°2.881",
    "fechaNacimientoVoluntario": "1985-05-15",
    "disponibilidadVoluntario": "2023-11-22",
    "emailVoluntario": "maria.gonzalez@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.593534,
        -33.42792
      ]
    }
  },
  {
    "nombreVoluntario": "Pedro",
    "habilidades": [
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Soto",
    "telefonoVoluntario": "+56909876543",
    "direccionVoluntario": "Leal N° 499",
    "fechaNacimientoVoluntario": "1993-09-20",
    "disponibilidadVoluntario": "2023-11-25",
    "emailVoluntario": "pedro.soto@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.635748,
        -33.491304
      ]
    }
  },
  {
    "nombreVoluntario": "Carla",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      }
    ],
    "apellidoVoluntario": "López",
    "telefonoVoluntario": "+56901234567",
    "direccionVoluntario": "Av. Vicuña Mackenna N° 584",
    "fechaNacimientoVoluntario": "1988-03-12",
    "disponibilidadVoluntario": "2023-11-28",
    "emailVoluntario": "carla.lopez@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.631806,
        -33.44859
      ]
    }
  },
  {
    "nombreVoluntario": "Miguel",
    "habilidades": [
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Martínez",
    "telefonoVoluntario": "+56907654321",
    "direccionVoluntario": "Venancia Leiva N° 2311",
    "fechaNacimientoVoluntario": "1995-07-30",
    "disponibilidadVoluntario": "2023-12-01",
    "emailVoluntario": "miguel.martinez@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.633001,
        -33.558203
      ]
    }
  },
  {
    "nombreVoluntario": "Fernanda",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Gómez",
    "telefonoVoluntario": "+56909876543",
    "direccionVoluntario": "Isidora Goyenechea Nº 3614",
    "fechaNacimientoVoluntario": "1983-11-05",
    "disponibilidadVoluntario": "2023-12-04",
    "emailVoluntario": "fernanda.gomez@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.5922,
        -33.4137
      ]
    }
  },
  {
    "nombreVoluntario": "Diego",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Hernández",
    "telefonoVoluntario": "+56901234567",
    "direccionVoluntario": "Pasaje Las Malvas N° 179",
    "fechaNacimientoVoluntario": "1992-04-18",
    "disponibilidadVoluntario": "2023-12-07",
    "emailVoluntario": "diego.hernandez@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.740746,
        -33.366722
      ]
    }
  },
  {
    "nombreVoluntario": "Ana",
    "habilidades": [
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Torres",
    "telefonoVoluntario": "+56907654321",
    "direccionVoluntario": "Diagonal Paraguay N° 406",
    "fechaNacimientoVoluntario": "1986-08-22",
    "disponibilidadVoluntario": "2023-12-10",
    "emailVoluntario": "ana.torres@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.641562,
        -33.442884
      ]
    }
  },
  {
    "nombreVoluntario": "Gonzalo",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      }
    ],
    "apellidoVoluntario": "Ramírez",
    "telefonoVoluntario": "+56909876543",
    "direccionVoluntario": "Artesanos N° 750",
    "fechaNacimientoVoluntario": "1998-02-10",
    "disponibilidadVoluntario": "2023-12-13",
    "emailVoluntario": "gonzalo.ramirez@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.650925,
        -33.431587
      ]
    }
  },
  {
    "nombreVoluntario": "Camila",
    "habilidades": [
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Silva",
    "telefonoVoluntario": "+56901234567",
    "direccionVoluntario": "Av. Einstein Nº 684",
    "fechaNacimientoVoluntario": "1991-06-25",
    "disponibilidadVoluntario": "2023-12-16",
    "emailVoluntario": "camila.silva@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.645477,
        -33.405472
      ]
    }
  },
  {
    "nombreVoluntario": "Ricardo",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Fuentes",
    "telefonoVoluntario": "+56907654321",
    "direccionVoluntario": "Calle San Joaquín 291, Rancagua",
    "fechaNacimientoVoluntario": "1984-12-15",
    "disponibilidadVoluntario": "2023-12-19",
    "emailVoluntario": "ricardo.fuentes@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.7015,
        -34.1725
      ]
    }
  },
  {
    "nombreVoluntario": "Lorena",
    "habilidades": [
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      }
    ],
    "apellidoVoluntario": "Herrera",
    "telefonoVoluntario": "+56909876543",
    "direccionVoluntario": "Union Obrera, 284 1048 Rancagua",
    "fechaNacimientoVoluntario": "1997-10-08",
    "disponibilidadVoluntario": "2023-12-22",
    "emailVoluntario": "lorena.herrera@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.73225982995358,
        -34.166472476475676
      ]
    }
  },
  {
    "nombreVoluntario": "Pablo",
    "habilidades": [
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      }
    ],
    "apellidoVoluntario": "Cáceres",
    "telefonoVoluntario": "+56901234567",
    "direccionVoluntario": "Calle 3 Norte 346, Talca",
    "fechaNacimientoVoluntario": "1989-03-28",
    "disponibilidadVoluntario": "2023-12-25",
    "emailVoluntario": "pablo.caceres@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -71.6618,
        -35.4271
      ]
    }
  },
  {
    "nombreVoluntario": "Catalina",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Vargas",
    "telefonoVoluntario": "+56907654321",
    "direccionVoluntario": "San Pedro Nolasco 380, Concepción",
    "fechaNacimientoVoluntario": "1994-07-03",
    "disponibilidadVoluntario": "2023-12-28",
    "emailVoluntario": "catalina.vargas@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -73.0457,
        -36.7777
      ]
    }
  },
  {
    "nombreVoluntario": "Felipe",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      }
    ],
    "apellidoVoluntario": "Mendoza",
    "telefonoVoluntario": "+56909876543",
    "direccionVoluntario": "Aníbal Pinto 335, Concepción",
    "fechaNacimientoVoluntario": "1987-11-18",
    "disponibilidadVoluntario": "2023-12-31",
    "emailVoluntario": "felipe.mendoza@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -73.0489,
        -36.8279
      ]
    }
  },
  {
    "nombreVoluntario": "Isabel",
    "habilidades": [
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Ortiz",
    "telefonoVoluntario": "+56901234567",
    "direccionVoluntario": "Doñigue 620, Punta Arenas",
    "fechaNacimientoVoluntario": "1996-05-05",
    "disponibilidadVoluntario": "2023-11-18",
    "emailVoluntario": "isabel.ortiz@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.9499,
        -53.12011
      ]
    }
  },
  {
    "nombreVoluntario": "Martín",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Lara",
    "telefonoVoluntario": "+56907654321",
    "direccionVoluntario": "Pasaje Antonio Benedicto Cebrian 621, Punta Arenas",
    "fechaNacimientoVoluntario": "1990-09-12",
    "disponibilidadVoluntario": "2023-11-21",
    "emailVoluntario": "martin.lara@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.9167,
        -53.15
      ]
    }
  },
  {
    "nombreVoluntario": "Javiera",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      }
    ],
    "apellidoVoluntario": "Rojas",
    "telefonoVoluntario": "+56909876543",
    "direccionVoluntario": "Regimiento Reforzado Nº20, Antofagasta",
    "fechaNacimientoVoluntario": "1982-02-28",
    "disponibilidadVoluntario": "2023-11-24",
    "emailVoluntario": "javiera.rojas@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.4163,
        -23.687
      ]
    }
  },
  {
    "nombreVoluntario": "Nicolás",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      }
    ],
    "apellidoVoluntario": "Gutiérrez",
    "telefonoVoluntario": "+56901234567",
    "direccionVoluntario": "Venezuela 894, Antofagasta",
    "fechaNacimientoVoluntario": "1981-07-15",
    "disponibilidadVoluntario": "2023-11-27",
    "emailVoluntario": "nicolas.gutierrez@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.4001,
        -23.6524
      ]
    }
  },
  {
    "nombreVoluntario": "Valentina",
    "habilidades": [
      {
        "codigo": "HH1",
        "descripcion": "Primeros Auxilios"
      },
      {
        "codigo": "HH2",
        "descripcion": "Rescate Acuático"
      },
      {
        "codigo": "HH3",
        "descripcion": "Manejo de Equipos de Emergencia"
      },
      {
        "codigo": "HH4",
        "descripcion": "Atención Médica Avanzada"
      }
    ],
    "apellidoVoluntario": "Hidalgo",
    "telefonoVoluntario": "+56907654321",
    "direccionVoluntario": "Manuel Bulnes 110, Iquique",
    "fechaNacimientoVoluntario": "1989-12-03",
    "disponibilidadVoluntario": "2023-11-30",
    "emailVoluntario": "valentina.hidalgo@example.com",
    "passwordVoluntario": "$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW",
    "geomVoluntario": {
      "type": "Point",
      "coordinates": [
        -70.1357,
        -20.2208
      ]
    }
  }])