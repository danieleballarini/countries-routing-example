import React, { useState, useEffect } from "react";
import { DataGrid } from '@material-ui/data-grid';

const columns = [
  { field: 'id', headerName: 'Id', width: 100 },
  { field: 'name', headerName: 'Name', width: 250 },
  { field: 'capital', headerName: 'Capital', width: 250 },
  {
    field: 'currencies',
    headerName: 'Currencies',
    sortable: false,
    width: 200,
    valueGetter: (params) => {      
      return !params || !params.value ? '' : params.value.reduce( (accumulator, currentValue, currentIndex, array) => {
        return `${accumulator}${currentIndex ? ',' : ''} ${currentValue.code}`
      }, '')
    }
  },
];

const rows = (countries) => {
  return !countries ? [] : countries.map( ( {name, capital, currencies}, idx ) => {
    return {
      id: ++idx,
      name, 
      capital,
      currencies
    }
  } )
}

const Countries = () => {
  const [hasError, setErrors] = useState(false);
  const [countries, setCountries] = useState([]);

  useEffect( () => {

    async function fetchData() {
      const res = await fetch("/api/countries");
      res
        .json()
        .then(res => setCountries(res))
        .catch(err => setErrors(err));
    }

    fetchData();      
  } );

  return (
    <DataGrid autoHeight rows={rows(countries)} columns={columns} pageSize={5} />      
  );  
}

export default Countries;
