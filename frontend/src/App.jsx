import React, { useEffect } from 'react'
import axios from 'axios';

const App = () => {
  useEffect(() => {
    axios.get("http://localhost:5000/api/health")
    .then(res => console.log(res.data))
    .catch(err => console.log(err));
  }, [])
  return (
    <div>App</div>
  )
}

export default App