export const getTicketPool = async () => {
    const res =await fetch("http://localhost:8080/api/ticket-pool/get",{
        method:"GET",
        Headers:{
            "content-type":"application/json",
        },
    })
    const ticket_pool = await res.json();
    console.log(ticket_pool);
    return ticket_pool;

}