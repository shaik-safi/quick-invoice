export default function InvoiceComponent() {
    return (
      <>
        <form onSubmit={this.handleSubmit}>
            <label>
                Name:
                <input type="text" value={this}></input>
            </label>

        </form>
      </>
    );
  }