import axios from "axios";


//for save the student
export async function saveStudentApi(data) {
   
    return await axios.post('http://localhost:2024/user/createUser', data, {
       headers: {
          'Content-Type': 'application/json'
       }
    })
} 
