function Badge(){

    const handleClick = () => {
        console.log('click event..');

        //logic
    }

    return (
        <button onClick={handleClick} type="button" className="btn btn-primary">
            Notifications <span className="badge text-bg-secondary">4</span>
        </button>
    )
}

export default Badge;