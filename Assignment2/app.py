from flask import Flask,render_template,request
import smtplib
import config
app = Flask(__name__)
@app.route('/')
def index():
    return render_template('index.html')

@app.route('/receive_details',methods=['POST'])
def receive_details():
    title = request.form['title']
    name = request.form['name']
    email = request.form['email']
    address = request.form['address']
    job_type = request.form['job_type']
    pincode = request.form['pincode']
    phone = request.form['phone']

    data = {
        'Title':title,
        'Name':name,
        'Email':email,
        'Address':address,
        'Job Type':job_type,
        'Pincode':pincode,
        'Phone':phone
    }
    session = smtplib.SMTP('smtp.gmail.com', 587)
    session.ehlo()
    session.starttls()
    session.login(config.emailId,config.password)
    headers = "\r\n".join(["from: " + 'raghav.ddps2@gmail.com',
                       "subject: " + "Your form submissions",
                       "to: " + email,
                       "mime-version: 1.0",
                       "content-type: text/html"])
    content = headers + "\r\n\r\n" + str(data)
    session.sendmail('raghav.ddps2@gmail.com',email, content)

    return render_template('response.html',data=data)
if __name__ == "__main__":
    app.run(debug=True)