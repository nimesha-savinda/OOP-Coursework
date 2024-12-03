export const getLatestConfiguration = async () => {
    const res =await fetch("http://localhost:8080/api/config/getLatest",{
        method:"GET",
        Headers:{
            "content-type":"application/json",
        },
    })
    const config = await res.json();
    console.log(config);
    return config;

}